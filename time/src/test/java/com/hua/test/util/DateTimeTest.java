/**
 * 描述: 
 * DateTimeTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.util;

//静态导入
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.time.chrono.IsoChronology;
import java.util.Calendar;
import java.util.TimeZone;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.hua.test.BaseTest;
import com.hua.util.DateTimeUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * DateTimeTest
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
public final class DateTimeTest extends BaseTest {

	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testDateTime() {
		try {
			/**
			 * 毫秒数: 从1970-01-01 00:00:00.000 GMT+0 开始算起
			 * 正数为后面(after)的时间，负数为前面(before)的时间
			 *
			 * 一天毫秒数: 86400000 (8千6百40万 =  24*60*60*1000)
			 * 计算哪一天的日期时间: 用当天毫秒数除以86400000 等到的整数为距离1970-01-01多少天从而计算出日期，
			 * 余数则为当天的时间.
			 */
			
			
			
			
		} catch (Exception e) {
			log.error("testDateTime =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testCalculateTime() {
		try {
			
			/**
			 * 毫秒数: 距离 1970-01-01, 00:00:00 GMT+0 (Greenwich Mean Time 格林威治标准时间)的毫秒数
			 * 计算方法: 距离1970-01-01的天数，乘以86400000，计算出格林威治的当前小时(不同时区要进行加减)
			 * 分钟、秒、毫秒数来运算.
			 * 因为时间戳纯粹是一个数字，不带有地区信息，因此，该数字在不同的时区有不同的小时显示，差值为时区和中时区之差.
			 */
			
			final long dayMillisec = 86400000L;
			// 今年
			final int currentYear = DateTimeUtil.getYear();
			final int startYear = 1970;
			int year = startYear;
			int totalDay = 0;
			while (year < currentYear) {
				if (DateTimeUtil.isLeapYear(year)) { // 闰年，366天
					totalDay += 366;
				} else { // 平年，365天
					totalDay += 365;
				}
				year++;
			}
			// 加上今年昨天的天数
			totalDay += DateTimeUtil.getDayOfYear() - 1;
			/*
			 * 计算出 格林威治的小时数 calendar.get(Calendar.HOUR_OF_DAY) 获取的是当前时区的
			 * 也可以指定中时区来计算小时数
			 */
			
			// 方式1: 获取中时区时间信息
			final Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
			final int hour = calendar.get(Calendar.HOUR_OF_DAY);
			final int minute = calendar.get(Calendar.MINUTE);
			final int second = calendar.get(Calendar.SECOND);
			final int millisecond = calendar.get(Calendar.MILLISECOND);
			
			// 方式2: 获取本地时区时间信息
			/*
			final Calendar calendar = DateTimeUtil.getCalendar();
			final int hour = calendar.get(Calendar.HOUR_OF_DAY) - 8;
			final int minute = calendar.get(Calendar.MINUTE);
			final int second = calendar.get(Calendar.SECOND);
			final int millisecond = calendar.get(Calendar.MILLISECOND); */
			
			
			
			// 距离 1970-01-01 00:00:00.000 的毫秒数
			// 手工计算
			long millisec = totalDay * dayMillisec + hour * 60 * 60 * 1000 + minute * 60 * 1000 + second * 1000 + millisecond;
			//System.out.println(totalDay * dayMillisec);
			System.out.println("手工计算: " + millisec);
			// 工具计算
			System.out.println("工具计算: " + calendar.getTimeInMillis());
		} catch (Exception e) {
			log.error("testCalculateTime =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void printTimeZone() {
		try {
			String[] ids = TimeZone.getAvailableIDs();
			for (String id : ids) {
				System.out.println(id);
			}
			
		} catch (Exception e) {
			log.error("printTimeZone =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testIsLeapYear() {
		try {
			int year = 20;
			System.out.println(DateTimeUtil.isLeapYear(year));
			System.out.println(IsoChronology.INSTANCE.isLeapYear(year));
			
		} catch (Exception e) {
			log.error("testIsLeapYear =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
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
	@DisplayName("testTemp")
	@Test
	public void testTemp() {
		try {
			System.out.println(DateTimeUtil.getDayOfYear());
			
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
	@DisplayName("testCommon")
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
	@DisplayName("testSimple")
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
	@DisplayName("testBase")
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("beforeMethod")
	@Tag(" [每个测试-方法]结束之后运行")
	@BeforeEach
	public void beforeMethod() {
		System.out.println("beforeMethod()");
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("afterMethod")
	@Tag(" [每个测试-方法]结束之后运行")
	@AfterEach
	public void afterMethod() {
		System.out.println("afterMethod()");
	}
	
	/**
	 * 
	 * 描述: 测试忽略的方法
	 * @author qye.zheng
	 * 
	 */
	@Disabled
	@DisplayName("ignoreMethod")
	@Test
	public void ignoreMethod() {
		System.out.println("ignoreMethod()");
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("noUse")
	@Disabled("解决ide静态导入消除问题 ")
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
		assertArrayEquals(expecteds, actuals, message);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(true, message);
		assertTrue(true, message);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(expecteds, actuals, message);
		assertNotSame(expecteds, actuals, message);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(actuals, message);
		assertNotNull(actuals, message);
		
		fail();
		fail("Not yet implemented");
		
		dynamicTest(null, null);
		
		assumeFalse(false);
		assumeTrue(true);
		assumingThat(true, null);
	}

}
