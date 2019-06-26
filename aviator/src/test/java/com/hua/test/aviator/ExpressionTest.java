/**
 * 描述: 
 * ExpressionTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.aviator;

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

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.hua.bean.User;
import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * ExpressionTest
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
public final class ExpressionTest extends BaseTest {

	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testExpression() {
		try {
			User dongFang = new User();
			dongFang.setNickname("东方");
			dongFang.setPassword("123456");
			dongFang.setOid(2019L);
			dongFang.setUsername("china");
			dongFang.setValid(true);
			
			User beiFang = new User();
			beiFang.setNickname("北方");
			beiFang.setPassword("123456");
			beiFang.setOid(2018L);
			beiFang.setUsername("china");
			beiFang.setValid(false);
				
			Map<String, Object> env = new HashMap<>();
			env.put("beiFang", beiFang);
			env.put("dongFang", dongFang);
			
			String expression = null;
			Expression compiledExp = null;
			Boolean result = false;
			
			// 用户名且密码一样
			expression = "(beiFang.username == dongFang.username) && (beiFang.password == dongFang.password)";
			// 编译表达式
			compiledExp = AviatorEvaluator.compile(expression);
			// 执行表达式
			result = (Boolean) compiledExp.execute(env);
			System.out.println("result = " + result);
			
			// oid 东方大于北方 或 北方是无效的
			expression = "(dongFang.oid > beiFang.oid) || (!beiFang.valid)";
			// 编译表达式
			compiledExp = AviatorEvaluator.compile(expression);
			// 执行表达式
			result = (Boolean) compiledExp.execute(env);
			System.out.println("result = " + result);			
			
			// 用户名且密码一样
			expression = "(beiFang.username == dongFang.username) && (beiFang.password == dongFang.password)";
			// 编译表达式
			compiledExp = AviatorEvaluator.compile(expression);
			// 执行表达式
			result = (Boolean) compiledExp.execute(env);
			System.out.println("result = " + result);
			
		} catch (Exception e) {
			log.error("testExpression =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 算术运算
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testArithmetic() {
		try {
			/*
			 * 加减乘除 求余
			 * ()括号运算
			 * ==:  等于，数值、字符串相等
			 * !=: 不等于
			 * 大于小于以及等于
			 */
			User dongFang = new User();
			dongFang.setNickname("东方");
			dongFang.setPassword("123456");
			dongFang.setOid(2019L);
			dongFang.setUsername("china");
			dongFang.setValid(true);
			
			User beiFang = new User();
			beiFang.setNickname("北方");
			beiFang.setPassword("123456");
			beiFang.setOid(2018L);
			beiFang.setUsername("china");
			beiFang.setValid(false);
				
			Map<String, Object> env = new HashMap<>();
			env.put("beiFang", beiFang);
			env.put("dongFang", dongFang);
			
			String expression = null;
			Expression compiledExp = null;
			Boolean result = false;
			
			// oid 东方大于北方 或 北方是无效的
			expression = "(dongFang.oid == (beiFang.oid + 1))";
			// 编译表达式
			compiledExp = AviatorEvaluator.compile(expression);
			// 执行表达式
			result = (Boolean) compiledExp.execute(env);
			System.out.println("result = " + result);		
			
			// oid 东方大于北方 或 北方是无效的
			expression = "(dongFang.oid != beiFang.oid)";
			// 编译表达式
			compiledExp = AviatorEvaluator.compile(expression);
			// 执行表达式
			result = (Boolean) compiledExp.execute(env);
			System.out.println("result = " + result);			
			
		} catch (Exception e) {
			log.error("testArithmetic =====> ", e);
		}
	}		
	
	/**
	 * 
	 * 描述: 字符串运算
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testRegex() {
		try {
			/*
			 * 加减乘除 求余
			 * ()括号运算
			 * ==:  等于，数值、字符串相等
			 * !=: 不等于
			 * 大于小于以及等于
			 */
			User dongFang = new User();
			dongFang.setNickname("东方");
			dongFang.setPassword("123456");
			dongFang.setOid(2019L);
			dongFang.setUsername("china");
			dongFang.setValid(true);
			
			User beiFang = new User();
			beiFang.setNickname("北方");
			beiFang.setPassword("123456");
			beiFang.setOid(2018L);
			beiFang.setUsername("china");
			beiFang.setValid(false);
				
			Map<String, Object> env = new HashMap<>();
			env.put("beiFang", beiFang);
			env.put("dongFang", dongFang);
			
			String expression = null;
			Expression compiledExp = null;
			Boolean result = false;
			
			/*
			 * 正则表达式
			 * 1) ~ /书写正则表达式/. 即以 ~ 开头，单斜杠包围起来
			 * 2) 
			 */
			//expression = "beiFang.nickname =~ /([.]*方$)/";
			// 以 nickname 方 结尾
			expression = "beiFang.nickname =~ /(.+方$)/";
			// 编译表达式
			compiledExp = AviatorEvaluator.compile(expression);
			// 执行表达式
			result = (Boolean) compiledExp.execute(env);
			System.out.println("result = " + result);		

			// password
			expression = "beiFang.password =~ /[1-6] {6}/";
			// 编译表达式
			compiledExp = AviatorEvaluator.compile(expression);
			// 执行表达式
			result = (Boolean) compiledExp.execute(env);
			System.out.println("result = " + result);					
			
			
		} catch (Exception e) {
			log.error("testRegex =====> ", e);
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
			System.out.println("北方".substring(1, 2));
			
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
