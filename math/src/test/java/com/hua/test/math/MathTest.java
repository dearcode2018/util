/**
 * 描述: 
 * MathTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.math;

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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * MathTest
 */
public final class MathTest extends BaseTest {

	/**
	 
	 public final class java.lang.Math
	 
	 */
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testMath() {
		try {
			
			double pi = Math.PI;
			
			double e = Math.E;
			log.info("testMath =====> pi = " + pi);
			log.info("testMath =====> e = " + e);
		} catch (Exception e) {
			log.error("testMath =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 随机数测试
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testRandom() {
		try {
			
			// [0.0, 1.0) 不包括1.0
			double rand = Math.random();
			log.info("testRandom =====> rand = " + rand);
			
			// 使用范例 (强转为整型)
			// 控制因子 factor [0, factor)
			int factor = 1;
			int result =  (int) (factor * Math.random());
			
			log.info("testRandom =====> result [0, 1) =  " + result);
			
			// 控制因子 factor [0, factor)
			factor = 10;
			result =  (int) (factor * Math.random());
			
			// 控制因子 factor [0, factor)
			factor = 12;
			result =  (int) (factor * Math.random());
			
			log.info("testRandom =====> result [0, 12) =  " + result);
			
			// 控制因子 factor [0, factor)
			factor = 100;
			result =  (int) (factor * Math.random());
			
			log.info("testRandom =====> result [0, 100) =  " + result);
			
			/**
			 可以封装一个工具类，根据因子 生成范围随机数
			 */
			
		} catch (Exception e) {
			log.error("testRandom =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 符号拷贝
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCopySign() {
		try {
			
			/**
			 正负数符号拷贝，两个操作数的符号不同，
			 如果两者符号相同，执行后则第一个操作数符号不变
			 Math.copySign(magnitude, sign)
			 
			 
			 */
			double magnitude = -10.02;
			double sign = 120.08;
			
			log.info("testCopySign =====> magnitude = " + magnitude);
			magnitude = Math.copySign(magnitude, sign);
			log.info("testCopySign =====> magnitude = " + magnitude);
			
		} catch (Exception e) {
			log.error("testCopySign =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 获取指数
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGetExponent() {
		try {
			float f = 1000.00F;
			log.info("testGetExponent =====> " + Math.getExponent(f));
			
		} catch (Exception e) {
			log.error("testGetExponent =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 计算直角三角形 斜边长
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testHypot() {
		try {
			
			/**
			 勾三股四玄五
			 */
			
			double a = 3.00;
			double b = 4.00;
			double c = Math.hypot(a, b);
			log.info("testHypot =====> c = " + c);
			
		} catch (Exception e) {
			log.error("testHypot =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 正负号函数
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSignum() {
		try {
			
			/*
			 0 -> 0.0
			 负数 -> -0.1
			 正数 -> 1.0
			 */
			double d = 0.0;
			log.info("testSignum =====> " + Math.signum(d));
			
			d = -0.5;
			log.info("testSignum =====> " + Math.signum(d));
			
			d = 0.5;
			log.info("testSignum =====> " + Math.signum(d));

			
		} catch (Exception e) {
			log.error("testSignum =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 指数运算
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testExp() {
		try {
			
			log.info("testExp =====>e =  " + Math.E);
			
			log.info("testExp =====> e^0 = " + Math.exp(0));
			
			log.info("testExp =====> e^1 =" + Math.exp(1));
			
			log.info("testExp =====> e^2 =" + Math.exp(2));
			
		} catch (Exception e) {
			log.error("testExp =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 对数运算
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testLog() {
		try {
			
			/**
			 double logeX
			 double log10X
			 */
			log.info("testLog =====> " + Math.log(Math.E));
			
			log.info("testLog =====> log10 = " + Math.log10(10));
			
			log.info("testLog =====> log10 = " + Math.log10(100));
			
		} catch (Exception e) {
			log.error("testLog =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 转为度数(角度)
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testToDegrees() {
		try {
			
			/**
			 3.14 --> 180°
			 */
			
			log.info("testToDegrees =====> " + Math.toDegrees(Math.PI));
			
		} catch (Exception e) {
			log.error("testToDegrees =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 转为弧度
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testToRadians() {
		try {
			/**
			 3.14 --> 180°
			 */
			log.info("testToRadians =====> " + Math.toRadians(180));
			
		} catch (Exception e) {
			log.error("testToRadians =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testNextUp() {
		try {
			
			/**
			 用法未明
			 */
			
			log.info("testNextUp =====> " + Math.nextUp(10.02));
			
			log.info("testNextUp =====> " + Math.nextUp(10.00));
			
		} catch (Exception e) {
			log.error("testNextUp =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testNextAfter() {
		try {
			/**
			 用法未明
			 */
			
		} catch (Exception e) {
			log.error("testNextAfter =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 四舍五入为整数
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testRound() {
		try {
			/*
			 四舍五入为整数
			 int Math.round(float)
			 long math.round(double)
			 主要是看第一位小数 (5进，4舍)
			 */
			
			float fl = 12.5536F;
			int in = Math.round(fl);
			log.info("testRound =====>  int Math.round(float) = " + in);
			
			double db = 12.4536;
			long lon = Math.round(db);
			log.info("testRound =====>  long math.round(double) = " + lon);
			
		} catch (Exception e) {
			log.error("testRound =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 向上取整
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCeil() {
		try {
			/**
			 向整数位取整，结果保留1位小数
			 向上取整: 向 >= 该值的整数方向靠拢
			 double Math.ceil(double)
			 */
			double db = 105.3546;
			double result = 0.0;
			result = Math.ceil(db);
			// 106.0
			log.info("testCeil =====> 正数(" + db + ") = " + result);
			
			db = 105.00;
			result = Math.ceil(db);
			// 106.0
			log.info("testCeil =====> 正数(" + db + ") = "  + result);
			
			db = -105.3546;
			result = Math.ceil(db);
			// -105.0
			log.info("testCeil =====> 负数(" + db + ") = "  + result);
			
			db = -105.00;
			result = Math.ceil(db);
			// -105.0
			log.info("testCeil =====> 负数(" + db + ") = "  + result);
			
		} catch (Exception e) {
			log.error("testCeil =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 向下取整
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFloor() {
		try {
			/**
			 向整数位取整，结果保留1位小数
			 向下取整: 向 <= 该值的整数方向靠拢
			 double Math.floor(double)
			 */
			double db = 105.3546;
			double result = 0.0;
			result = Math.floor(db);
			// 105.0
			log.info("testFloor =====> 正数(" + db + ") = " + result);
			
			db = 105.00;
			result = Math.floor(db);
			// 105.0
			log.info("testFloor =====> 正数(" + db + ") = "  + result);
			
			db = -105.3546;
			result = Math.floor(db);
			// -106.0
			log.info("testFloor =====> 负数(" + db + ") = "  + result);
			
			db = -105.00;
			result = Math.floor(db);
			// -105.0
			log.info("testFloor =====> 负数(" + db + ") = "  + result);
			
		} catch (Exception e) {
			log.error("testFloor =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 平方根、立方根 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSqrtAndCbrt() {
		try {
			/*
			 平方根: Math.sqrt(double)
			 立方根: Math.cbrt(double)
			 */
			
			double db = 4.0;
			log.info("testSqrtAndCbrt =====> (db = " + db + ") 平方根 = " + Math.sqrt(db));
			
			
			db = 8.0;
			log.info("testSqrtAndCbrt =====> (db = " + db + ") 平方根 = " + Math.cbrt(db));
			
		} catch (Exception e) {
			log.error("testSqrtAndCbrt =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 幂运算
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testPow() {
		try {
			
			
			/*
			  x^y 幂运算
			 */
			
			double x = 2.0;
			double y = 3.0;
			
			log.info("testPow =====> " + Math.pow(x, y));
			
		} catch (Exception e) {
			log.error("testPow =====> ", e);
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
