/**
 * 描述: 
 * DateTimeTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.jdk;

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
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;


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
	public void testDateTime() {
		try {
			
			
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
			Thread.sleep(10);
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
