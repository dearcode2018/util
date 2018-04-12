/**
 * TimeZoneUtil.java
 * @author  qye.zheng
 * 
 * 	version 1.0
 */
package com.hua.util;

import java.util.TimeZone;

import com.hua.constant.Constant;

/**
 * TimeZoneUtil
 * 描述: 时区 - 工具
 * @author  qye.zheng
 * 
 */
public final class TimeZoneUtil
{

	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 * 
	 */
	private TimeZoneUtil()
	{
	}

	/**
	 * 
	 * 描述: 获取服务器所在的时区
	 * @author  qye.zheng
	 * 
	 * @return
	 */
	public TimeZone getServerTimeZone()
	{
		TimeZone timeZone = TimeZone.getDefault();
		
		return timeZone;
	}
	
	/**
	 * 
	 * 描述: 获取客户端所在的时区
	 * @author  qye.zheng
	 * 
	 * @param id 时区id，例如 中国东八区( id == GMT+8:00 或 GMT+8 )
	 * @return
	 */
	public TimeZone getClientTimeZone(final String id)
	{
		TimeZone timeZone = TimeZone.getTimeZone(id);
		
		return timeZone;
	}
	
	/**
	 * 
	 * 描述: 获取中国所在的时区
	 * @author  qye.zheng
	 * 
	 * @param id 时区id，例如 中国东八区( id == GMT+8:00 或 GMT+8 )
	 * @return
	 */
	public TimeZone getChinaTimeZone()
	{
		TimeZone timeZone = TimeZone.getTimeZone(Constant.TIME_ZONE_ID_CHINA);
		
		return timeZone;
	}
	
}
