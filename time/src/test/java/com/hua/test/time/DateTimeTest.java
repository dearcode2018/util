/**
 * 描述: 
 * DateTimeTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.time;

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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

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
	@Test
	public void testSimpleDateFormat() {
		try {
			DateFormat df = new SimpleDateFormat("yyyyMMdd");
			Callable<Date> task = new Callable<Date>()
			{
				@Override
				public Date call() throws Exception
				{
					return df.parse("20180520");
				}
			};
			
			ExecutorService pool = Executors.newFixedThreadPool(10);
			List<Future<Date>> results = new ArrayList<>();
			for (int i = 0; i < 10; i++)
			{
				results.add(pool.submit(task));
			}
			for (Future<Date> future : results)
			{
				System.out.println(future.get());
			}
					
					
		} catch (Exception e) {
			log.error("testSimpleDateFormat =====> ", e);
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
			DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
			Callable<LocalDate> task = new Callable<LocalDate>()
			{
				@Override
				public LocalDate call() throws Exception
				{
					return LocalDate.parse("20180520", df);
				}
			};
			
			ExecutorService pool = Executors.newFixedThreadPool(10);
			List<Future<LocalDate>> results = new ArrayList<>();
			for (int i = 0; i < 10; i++)
			{
				results.add(pool.submit(task));
			}
			for (Future<LocalDate> future : results)
			{
				System.out.println(future.get());
			}
		
			DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
			LocalDateTime ldt = LocalDateTime.now();
			System.out.println(dtf.format(ldt));
			
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
	public void testLocalDateTime() {
		try {
			/**
			 * LocalDate LocalTime LocalDateTime 是人类阅读的日期时间
			 */
			LocalDateTime localDateTime = LocalDateTime.now();
			// 2018-05-20T12:28:03.493
			System.out.println(localDateTime.toString());
			
			localDateTime = LocalDateTime.of(2018, 05, 20, 12, 28, 30);
			System.out.println(localDateTime.toString());
			
			/*
			 * 都是不可变对象，需要接收返回的新变量
			 */
			// 加2年
			localDateTime = localDateTime.plusYears(2);
			System.out.println(localDateTime.toString());
			// 月份数，具体的月份，从1开始，与Calendar不同(从0开始).
			System.out.println(localDateTime.getMonthValue());
		} catch (Exception e) {
			log.error("testLocalDateTime =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testInstant() {
		try {
			/**
			 * Instant 时间戳，计算机阅读的时间
			 * 以Unix元年: 1970-01-01 00:00:00.000 到某个时间之间的毫秒值
			 */
			Instant instant = Instant.now();
			/*
			 * 2018-05-20T04:38:05.608Z
			 * 默认获取以UTC(格林威治)时区
			 */
			System.out.println(instant);
			
			OffsetDateTime odf = instant.atOffset(ZoneOffset.ofHours(8));
			// 2018-05-20T12:41:20.418+08:00
			System.out.println(odf);
			// 时间戳 毫秒值 1526791381966
			System.out.println(instant.toEpochMilli());
			
			Instant instant2 = Instant.ofEpochSecond(1);
			// 1970-01-01T00:00:01Z
			System.out.println(instant2);
			
		} catch (Exception e) {
			log.error("testInstant =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 时间间隔
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDuration() {
		try {
			Instant instant1 = Instant.now();
			TimeUnit.MILLISECONDS.sleep(500);
			Instant instant2 = Instant.now();
			System.out.println(Duration.between(instant1, instant2).getNano());
			System.out.println(Duration.between(instant1, instant2).toMillis());
			
		} catch (Exception e) {
			log.error("testDuration =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 日期间隔
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testPeriod() {
		try {
			LocalDate localDateTime1 = LocalDate.of(2018,  01, 19);
			// localDateTime1 = LocalDate.of(2018,  05, 21);
			LocalDate localDateTime2 = LocalDate.now();
			
			System.out.println(Period.between(localDateTime1, localDateTime2).getDays());
			
		} catch (Exception e) {
			log.error("testPeriod =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testTemporalAdjuster() {
		try {
			/**
			 * 时间校正器
			 */
			LocalDateTime ldt = LocalDateTime.now();
			LocalDateTime ldt2 =ldt.withDayOfMonth(10);
			System.out.println(ldt2);
			//TemporalAdjusters
			LocalDateTime ldt3=ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
			System.out.println(ldt3);
			
			ldt.with((x) -> {
				LocalDateTime ldt4 = (LocalDateTime) x;
				DayOfWeek dow = ldt4.getDayOfWeek();
				if (DayOfWeek.FRIDAY.equals(dow))
				{
					return ldt4.plusDays(3);
				} else if (DayOfWeek.SATURDAY.equals(dow))
				{
					return ldt4.plusDays(2);
				} else
				{
					return ldt4.plusDays(1);
				}
			});
			System.out.println(ldt);
		} catch (Exception e) {
			log.error("testTemporalAdjuster =====> ", e);
		}
	}
	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testTimeZone() {
		try {
			/*
			 * 所有时区
			 */
			Set<String> set = ZoneId.getAvailableZoneIds();
			for (String e : set)
			{
				System.out.println(e);
			}
			LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Europe/Tallinn"));
			ZonedDateTime zdt = ldt.atZone(ZoneId.of("Europe/Tallinn"));
			System.out.println(zdt);
		} catch (Exception e) {
			log.error("testTimeZone =====> ", e);
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
