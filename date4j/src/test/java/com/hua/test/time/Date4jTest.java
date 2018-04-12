/**
 * 描述: 
 * Date4jTest.java
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

import java.util.Locale;

import org.intelligentsia.hirondelle.date4j.DateTime;
import org.intelligentsia.hirondelle.date4j.DateTime.Unit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.constant.FormatConstant;
import com.hua.test.BaseTest;
import com.hua.util.DateTimeUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * Date4jTest
 */
public final class Date4jTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDateTime() {
		try {
			DateTime dt = DateTime.forDateOnly(2014, 7, DateTimeUtil.getDayOfMonth());
			
			log.info("testDateTime =====> 是否闰年: " + dt.isLeapYear());
			
			// 暂时无法解决
			log.info("testDateTime =====> 格式化: " + dt.format(FormatConstant.DATE_FORMAT_yyyy_MM_dd, Locale.CHINESE));
			
			log.info("testDateTime =====> 毫秒数(参照所在的时区)" + dt.getMilliseconds(DateTimeUtil.getTimeZone()));
			
			log.info("testDateTime =====> 当前月共多少天: " + dt.getNumDaysInMonth());
			
			//log.info("testDateTime =====> " + dt.getRawDateString());
			
			log.info("testDateTime =====> " + dt.getYear());
			
			log.info("testDateTime =====> " + dt.getMonth());
			
			log.info("testDateTime =====> 月的天: " + dt.getDay());
			
			log.info("testDateTime =====> 星期数(1-星期日): " + dt.getWeekDay());
			
			log.info("testDateTime =====> " + dt.getHour());
			
			// 2014-07-29 00:00:00.000000000
			log.info("testDateTime =====> 获取当天开始时刻(精确到 - 纳秒):" + dt.getStartOfDay());
			
			// 2014-07-29 23:59:59.999999999
			log.info("testDateTime =====> 获取当天最后时刻(精确到 - 纳秒): " + dt.getEndOfDay());
			
			// 2014-07-01 00:00:00.000000000
			log.info("testDateTime =====> 获取当月开始时刻(精确到 - 纳秒): " + dt.getStartOfMonth());
			
			// 2014-07-31 23:59:59.999999999
			log.info("testDateTime =====> 获取当月最后时刻(精确到 - 纳秒): " + dt.getEndOfMonth());
			
			// 可以精确到 日 / 时/ 分 / 秒 ...
			log.info("testDateTime =====> 获取构造的对象的精确度: " + dt.getPrecision());
			
			log.info("testDateTime =====> 是否包含年月日: " + dt.hasYearMonthDay());
			
			log.info("testDateTime =====> 是否包含时分秒: " + dt.hasHourMinuteSecond());
			
			// 把指定单位之前的值截取掉，不含此时指定的单位
			DateTime dt2 = dt.truncate(Unit.MONTH);
			// MONTH 之前的都被截取了，变成了null
			log.info("testDateTime =====> " + dt2.getDay());
			
			//log.info("testDateTime =====> " + DateTime.isParseable("2014-05-12"));
			
			//  DateTime.DayOverflow 天数 溢出处理: 指向下个月的第一天、指向本月的最后一天
			
			
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
	@Test
	public void testDateTimeFormatter() {
		try {
			
			
		} catch (Exception e) {
			log.error("testDateTimeFormatter =====> ", e);
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
	 * 描述: 普通测试方法
	 ,@Test注解 不带参数
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testNormal() {
		System.out.println("testNormal()");
	}
	
	/**
	 * 
	 * 描述: 期望发生异常-测试方法
	 ,@Test注解 异常
	 * @author qye.zheng
	 * 
	 */
	@Test(expected=NullPointerException.class)
	@SuppressWarnings("all")
	public void testException() {
		String str = null;
		System.out.println(str.length());
	}
	
	/**
	 * 
	 * 描述: 超时测试方法
	 ,@Test注解 指定运行时间 (单位 : 毫秒)
	 * @author qye.zheng
	 * 
	 */
	@Test(timeout=3000)
	public void testTimeOut() {
		System.out.println("testTimeOut()");
	}
	
	/**
	 * 
	 * 描述: 测试忽略的方法
	 * @author qye.zheng
	 * 
	 */
	@Ignore("暂时忽略的方法")
	@Test
	public void ignoreMethod() {
		System.out.println("ignoreMethod()");
	}
	
	/**
	 * 
	 * 描述: [所有测试]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass()");
	}
	
	/**
	 * 
	 * 描述: [所有测试]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@AfterClass
	public static void afterClass() {
		System.out.println("afterClass()");
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@Before
	public void beforeMethod() {
		System.out.println("beforeMethod()");
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@After
	public void afterMethod() {
		System.out.println("afterMethod()");
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
