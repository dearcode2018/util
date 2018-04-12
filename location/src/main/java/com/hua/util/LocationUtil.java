/**
 * LocationUtil.java
 * @author  qye.zheng
 * 
 * 	version 1.0
 */
package com.hua.util;

import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hua.entity.location.Location;
import com.hua.util.StringUtil;

/**
 * LocationUtil 描述: 位置工具
 * 
 * @author qye.zheng
 * 
 */
public final class LocationUtil
{

	/**
	 * 支持从百度提供的位置接口中获取位置信息
	 * 
	 */

	private static final HttpClient httpClient = HttpClientBuilder.create().build();

	private static HttpGet httpGet;

	//private static HttpPost httpPost;

	//private static HttpRequest request;

	private static HttpResponse response;

	private static InputStream input;

	private static String baiduApiUrl = "http://api.map.baidu.com/geocoder/v2/";
	
	private static final JsonParser jsonParser = new JsonParser();

	/**
	 * 构造方法 描述:
	 * 
	 * @author qye.zheng
	 * 
	 */
	private LocationUtil()
	{
	}

	/**
	 * 
	 * 描述:
	 * 
	 * @author qye.zheng
	 * 
	 * @param address
	 *            地址 : 请求参数
	 * @return
	 */
	public static Location getLocation(final String address)
	{
		/** begin 异常拦截段 */
		if (StringUtil.isEmpty(address))
		{
			// 位置参数为空

			throw new IllegalArgumentException("位置参数不能为空");
		}
		/** end of 异常拦截段 */
		/**
		 * org.apache.http.client.HttpClient
		 * 
		 * 通过 HttpClientBuilder 来构建HttpClient 对象
		 * 
		 * DefaultHttpClient 等实现对象已经过时，不推荐使用
		 */
		/**
		 * 请求url 示例
		 * http://api.map.baidu.com/geocoder/v2/?address=百度大厦&output=json
		 * &ak=E4805d16520de693a3fe707cdc962045&callback=showLocation
		 * 
		 * 响应数据 :
		 *  {"status":0,"result":{"location":{"lng":116.30814954222,"lat":40.056885091681},"precise":1,"confidence":80,"level":"\u5546\u52a1\u5927\u53a6"}}
		 */

		// http://api.map.baidu.com/geocoder/v2/?ak=WmmqGhrglDmznnfflATms4tx&output=json&address=百度大厦

		//baiduApiUrl = "http://api.map.baidu.com/geocoder/v2/";
		//
		try
		{
			// http get 实例
			httpGet = new HttpGet(baiduApiUrl
					+ "?ak=WmmqGhrglDmznnfflATms4tx&output=json&address="
					+ address);

			response = httpClient.execute(httpGet);
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode())
			{
				// 成功响应 200 ok
				input = response.getEntity().getContent();
				// 使用 Gson JsonParser 解析响应数据
				final JsonElement e = jsonParser.parse(new InputStreamReader(input));
				final JsonObject jsonObj = e.getAsJsonObject();
				final JsonObject locationObj = jsonObj.getAsJsonObject("result").getAsJsonObject("location");
				// 构造位置对象
				final Location location = new Location();
				location.setLongitude(locationObj.get("lng").getAsFloat());
				location.setLatitude(locationObj.get("lat").getAsFloat());
				
				return location;
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}
	
}