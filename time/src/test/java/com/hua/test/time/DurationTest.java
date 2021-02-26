/**
 * 描述: 
 * DurationTest.java
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

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.hua.constant.Constant;
import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * DurationTest
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
public final class DurationTest extends BaseTest {

	
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
			Duration duration = Duration.between(instant1, instant2);
			System.out.println(duration.toMillis());
			
		} catch (Exception e) {
			log.error("testDuration =====> ", e);
		}
	}
	
	
	/**
	 * 
	 * 描述: 时间间隔
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDurationInstant() {
		try {
			Instant instant1 = Instant.now();
			TimeUnit.MILLISECONDS.sleep(500);
			Instant instant2 = Instant.now();
			Duration duration = Duration.between(instant1, instant2);
			System.out.println(duration.toMillis());
			
		} catch (Exception e) {
			log.error("testDuration =====> ", e);
		}
	}
	
	
	/**
	 * 
	 * 描述: 时间间隔
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDurationDate() {
		try {
			Date date1 = new Date();
			Instant instant1 = date1.toInstant();
			TimeUnit.MILLISECONDS.sleep(500);
			Date date2 = new Date();
			Instant instant2 = date2.toInstant();
			
			Duration duration = Duration.between(instant1, instant2);
			System.out.println(duration.toMillis());
			
		} catch (Exception e) {
			log.error("testDuration =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 时间间隔
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDurationLocalDateTime() {
		try {
			LocalDateTime dateTime1 = LocalDateTime.now();
			
			TimeUnit.MILLISECONDS.sleep(500);
			
			LocalDateTime dateTime2 = LocalDateTime.now();
			Duration duration = Duration.between(dateTime1, dateTime2);
			
			System.out.println(duration.toMillis());
			
		} catch (Exception e) {
			log.error("testDuration =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 时间间隔
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDurationOffsetDateTime() {
		try {
			OffsetDateTime offsetDateTime1 = Instant.now().atOffset(ZoneOffset.of(Constant.DEFAULT_ZONE_OFFSET));
			
			TimeUnit.MILLISECONDS.sleep(500);
			
			OffsetDateTime offsetDateTime2 = Instant.now().atOffset(ZoneOffset.of(Constant.DEFAULT_ZONE_OFFSET));
			Duration duration = Duration.between(offsetDateTime1, offsetDateTime2);
			System.out.println(duration.toMillis());
			
		} catch (Exception e) {
			log.error("testDuration =====> ", e);
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
	public void testDurationValue() {
		try {
			Duration duration = Duration.ofHours(1);
			System.out.println(String.format("one hour minute: %d", duration.toMinutes()));
			
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
	//@DisplayName("test")
	@Test
	public void testBetween() {
		try {
			LocalTime time1 = LocalTime.now();
			LocalTime time2 = time1.plusHours(1);
			Duration duration = Duration.between(time1, time2);
			System.out.println(String.format("duration hour between: %d", duration.toHours()));
			
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
