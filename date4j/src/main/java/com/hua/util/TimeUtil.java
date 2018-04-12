/**
 * TimeUtil.java
 * @author  qye.zheng
 * 
 * 	version 1.0
 */
package com.hua.util;

import java.sql.Time;
import java.util.Calendar;

/**
 * TimeUtil
 * 描述: 时间 - 工具
  * HH:mm:ss
 * @author  qye.zheng
 * 
 */
public final class TimeUtil
{

	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 * 
	 */
	private TimeUtil()
	{
	}
	
	/**
	 * 
	 * 描述:  获取当前时间数值
	 * 
	 * @author qye.zheng
	 * @return
	 */
	public static Time getTime() {
		// 每次都获取一个最新的日历 - 当前时间
		final Calendar calendar = Calendar.getInstance();
		
		return new Time(calendar.getTimeInMillis());
	}

}
