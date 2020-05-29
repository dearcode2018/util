/**
  * @filename SensitiveWrodInit.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.filte;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.hua.constant.Constant;
import com.hua.util.ClassPathUtil;
import com.hua.util.IOUtil;
import com.hua.util.StringUtil;

 /**
 * @type SensitiveWrodInit
 * @description 敏感词初始化
 * @author qianye.zheng
 */
public class SensitiveWrodInit
{
	private static Map<Object, Object> sensitiveWordMap;
	
	private static final String PATH = "/conf/SensitiveWord.txt";
	
	/**
	 * 
	 * @description 初始化敏感词数据
	 * @return
	 * @author qianye.zheng
	 */
	public static final Map<Object, Object> init()
	{
		//读取敏感词库
		final Set<String> keyWordSet = readWordFile();
		addSensitiveWordToMap(keyWordSet);
		
		return sensitiveWordMap;
	}
	
	/**
	 * 
	 * @description 将敏感词(每个字符)构建到一个哈希结构中
	 * @param keyWordSet
	 * @author qianye.zheng
	 */
	@SuppressWarnings({"unchecked"})
	private static final void addSensitiveWordToMap(final Set<String> keyWordSet)
	{
		// 为空才执行组装动作
		if (null == sensitiveWordMap)
		{
			sensitiveWordMap = new HashMap<Object, Object>(keyWordSet.size());
			// 关键字
			String key = null;
			Map<Object, Object> nowMap = null;
			Map<Object, Object> newWordMap = null;
			final Iterator<String> iterator = keyWordSet.iterator();
			Object wordMap = null;
			while (iterator.hasNext())
			{
				// 每行敏感词组执行的处理
				key = iterator.next();
				nowMap = sensitiveWordMap;
				if (StringUtil.isEmpty(key))
				{
					// 防止脏数据
					continue;
				}
				for (int i = 0; i < key.length(); i++)
				{
					// 转换成char类型
					char keyChar = key.charAt(i);
					// 根据字符获取对应的Map对象
					wordMap = nowMap.get(keyChar);
					if (null == wordMap)
					{ // 不存在则构建一个新的Map，同时将isEnd设置为0，假设不是最后一个
						newWordMap = new HashMap<Object,Object>();
						newWordMap.put("isEnd", "0");
						// 以一个字符为key建立级联关系
						nowMap.put(keyChar, newWordMap);
						// 将新的Map赋给当前的Map
						nowMap = newWordMap;
					} else
					{ // 已经存在，直接赋值，继续往下级联
						nowMap = (Map<Object, Object>) wordMap;
					}
					// 最后一个
					if (i == key.length() - 1)
					{ // 最后一个
						nowMap.put("isEnd", "1"); 
					}
				}
			}
		}
	}
	
	/**
	 * 
	 * @description 读取敏感词文件组装为集合
	 * @return
	 * @author qianye.zheng
	 */
	private static final Set<String> readWordFile()
	{
		final Set<String> set = new HashSet<String>();
		Reader reader = null;
		BufferedReader bufferedReader = null;
		try
		{
			final File file = new File(ClassPathUtil.getClassPath(PATH));
			reader = new InputStreamReader(new FileInputStream(file), Constant.CHART_SET_UTF_8);
			bufferedReader = new BufferedReader(reader);
			String line = null;
			while (null != (line = bufferedReader.readLine()))
			{
				set.add(line);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			IOUtil.close(reader);
			IOUtil.close(bufferedReader);
		}
		
		return set;
	}
}
