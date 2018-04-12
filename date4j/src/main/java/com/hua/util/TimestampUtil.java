/**
 * TimestampUtil.java
 * @author  qye.zheng
 * 
 * 	version 1.0
 */
package com.hua.util;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * TimestampUtil
 * 描述: 时间戳 - 工具
 * @author  qye.zheng
 * 
 */
public final class TimestampUtil
{

	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 * 
	 */
	private TimestampUtil()
	{
	}
	
	/**
	 * 
	 * 描述: 获取当前时间戳
	 * java.sql.Timestamp
	 * @author  qye.zheng
	 * 
	 * @return
	 */
	public static Timestamp getTimestamp()
	{
		// 每次都获取一个最新的日历 - 当前时间
		final Calendar calendar = Calendar.getInstance();
		
		return new Timestamp(calendar.getTimeInMillis());
	}

}
