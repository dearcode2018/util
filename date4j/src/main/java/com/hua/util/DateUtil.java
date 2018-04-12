/**
 * DateUtil.java
 * @author  qye.zheng
 * 
 * 	version 1.0
 */
package com.hua.util;

import java.util.Calendar;

/**
 * DateUtil
 * 描述: 日期 - 工具
 * YYYY-MM-dd
 * @author  qye.zheng
 * 
 */
public final class DateUtil
{

	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 * 
	 */
	private DateUtil()
	{
	}
	
	/**
	 * 
	 * 描述: 获取当前日期 java.sql.Date
	 * 只含日期，不含时间
	 * 
	 * @author qye.zheng
	 * @return
	 */
	public static java.sql.Date getDate() {
		// 每次都获取一个最新的日历 - 当前时间
		final Calendar calendar = Calendar.getInstance();
		
		return new java.sql.Date(calendar.getTimeInMillis());
	}
	
	/**
	 * 
	 * 描述: 获取指定毫秒数的日期对象 java.sql.Date
	 * @author  qye.zheng
	 * 
	 * @param millisecond
	 * @return
	 */
	public static java.sql.Date getDate(final long millisecond)
	{
		return new java.sql.Date(millisecond);
	}

}
