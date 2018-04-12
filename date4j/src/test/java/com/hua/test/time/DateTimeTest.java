/**
 * 描述: 
 * DateTimeTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.time;

// 静态导入
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;
import com.hua.util.DateTimeUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * DateTimeTest
 */
public final class DateTimeTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testUTC() {
		try {
			/**
			 * UTC: Universal Time Coordinated 协调世界时间
			 * 从 1970-01-01 00:00:00.000 开始经过的毫秒数来
			 * 保存日期时间，Date类型可以保存的日期时间精确
			 * 到1970-01-01 00:00:00.000前、后的285616年
			 * 毫秒数负数: 表示1970-01-01 00:00:00.000之前
			 * 毫秒数正数: 表示1970-01-01 00:00:00.000之后
			 * 毫秒数类型: 64位 long
			 * UTC值和时区有关: 例如 东8区，是从1970-01-01 08:00:00.000 开始
			 * 累积毫秒数
			 * dateTime / date / time: 均存放了从当前时区的零时开始积累的年月日时分秒毫秒
			 * 
			 */
			
			/*
			 * 日期: 年-月-日
			 * 时间: 时:分:秒.毫秒
			 * 
			 */
			Calendar cal = Calendar.getInstance();
			// 获取当前
			//cal.set(Calendar.HOUR, Constant.ZERO);
			System.out.println("Calendar currentTimeInMillis = " + cal.getTimeInMillis());
			
			java.util.Date dateTime = new java.util.Date(cal.getTimeInMillis());
			System.out.println("dateTime = " + dateTime.getTime());
			
			java.sql.Date date = new java.sql.Date(cal.getTimeInMillis());
			System.out.println("date = " + date.getTime());
			
			Time time = new Time(cal.getTimeInMillis());
			System.out.println("time = " + time.getTime());
			//System.out.println("当前时间距 1970-01-01 00:00:00.000 的毫秒数 = " + time.getTime());
			//System.out.println(dateTime.toLocaleString());
			//System.out.println(date.toLocaleString());
			//System.out.println(time.toLocaleString());
			
			time = new Time(0);
			System.out.println(time.getTime());
			date = DateTimeUtil.parseDate("2014-10-25");
			System.out.println(date.toLocaleString());
			time = DateTimeUtil.parseTime("09:36:20");
			System.out.println("距离东八区 08:00:00.000的毫秒值: " + time.getTime());
			System.out.println(time.toLocaleString());
			// 5780000
			System.out.println(1 * 60 * 60 * 1000 + 36 * 60 * 1000 + 20 * 1000);
			//System.out.println(time.toLocaleString());
		} catch (Exception e) {
			log.error("testUTC =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCalendarObj() {
		try {
			
			// 时间1
			log.info("testCalendarObj =====> " + DateTimeUtil.getTimeInMillis());
			
			Thread.sleep(5 * 1000);
			
			// 时间2
			log.info("testCalendarObj =====> " + DateTimeUtil.getTimeInMillis());
			
			/*
			 时间1 == 时间2，Calendar.getInstance() 生成一个日历对象，其时间值不会
			 再改变，而是一直保持类加载时的值，因此，不能试图通过一次Calendar.getInstance()
			 来在系统的整个运行过程中获取当前最新的时间.
			 
			 */
			
			Calendar cal = Calendar.getInstance();
			
			log.info("testCalendarObj =====> " + cal.getTimeInMillis());
			
		} catch (Exception e) {
			log.error("testCalendarObj =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testTemp() {
		try {
			
			log.info("testTemp =====> " + DateTimeUtil.getTimeInMillis());
			
			Thread.sleep(5 * 1000);
			
			log.info("testTemp =====> " + DateTimeUtil.getTimeInMillis());
			
		} catch (Exception e) {
			log.error("testTemp=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCommon() {
		try {
			
			
		} catch (Exception e) {
			log.error("testCommon =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSimple() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSimple =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@Ignore("解决ide静态导入消除问题 ")
	private void noUse() {
		String expected = null;
		String actual = null;
		Object[] expecteds = null;
		Object[] actuals = null;
		String message = null;
		
		assertEquals(expected, actual);
		assertEquals(message, expected, actual);
		assertNotEquals(expected, actual);
		assertNotEquals(message, expected, actual);
		
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(message, expecteds, actuals);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(message, true);
		assertTrue(message, true);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(message, expecteds, actuals);
		assertNotSame(message, expecteds, actuals);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(message, actuals);
		assertNotNull(message, actuals);
		
		assertThat(null, null);
		assertThat(null, null, null);
		
		fail();
		fail("Not yet implemented");
		
	}

}
