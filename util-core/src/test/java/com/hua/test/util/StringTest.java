/**
 * 描述: 
 * StringTest.java
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
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;



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
 * StringTest
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
public final class StringTest extends BaseTest {

	
	/**
	 * java.lang.String
	 * 
	 * 底层由字符数组构成，下标从 0 开始
	 * 长度 : length()
	 * 最后一个下标 : length() - 1 
	 *
	 * 
	 */
	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testHanZi() {
		try {
			/*
			1、英文字母: 
			 字节数 : 1;编码：GB2312

			字节数 : 1;编码：GBK
			
			字节数 : 1;编码：GB18030
			
			字节数 : 1;编码：ISO-8859-1
			
			字节数 : 1;编码：UTF-8
			
			字节数 : 4;编码：UTF-16
			
			字节数 : 2;编码：UTF-16BE
			
			字节数 : 2;编码：UTF-16LE
			
			
			2、中文汉字:
			字节数 : 2;编码：GB2312
			
			字节数 : 2;编码：GBK
			
			字节数 : 2;编码：GB18030
			
			字节数 : 1;编码：ISO-8859-1
			
			字节数 : 3;编码：UTF-8
			
			字节数 : 4;编码：UTF-16
			
			字节数 : 2;编码：UTF-16BE
			
			字节数 : 2;编码：UTF-16LE			
			
			 */
			String value = "中";
			// 中文 3个字节
			System.out.println(value.getBytes().length);
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 范围
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testRange() {
		try {
			// 开始下标(包括) 到 最后 substring(int startIndex)
			// 开始下标(包括) 到 结束下标(不包括)
			String str = "abAc123eAfg456";
			//log.info("testRange =====> " + str.substring(2));
			//log.info("testRange =====> "+ str.substring(2, 4));
			
			//log.info("testRange =====> " + str.indexOf("A"));
			//log.info("testRange =====> " + str.indexOf("A", 3));
			
			 str = "line1 abc123efg456\nline2 hahawhoami, this is my\toh,no\nline3 no request";
			 
			 log.info("testRange =====> " + str.indexOf("\n"));
			 log.info("testRange =====> " + str.indexOf("\n", 19));
			 
			 
			log.info("testRange =====> str --> " + str);
			int index = 0;
			
			log.info("testRange =====> " + str.indexOf("\n", index));
			index = str.indexOf("\n", index) + 1;
			
			log.info("testRange =====> " + str.indexOf("\n", index));
			index = str.indexOf("\n", index) + 1;
			
			
			log.info("testRange =====> " + str.indexOf("\n", index));
			
		} catch (Exception e) {
			log.error("testRange =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFind() {
		try {
			String str = "------websymbolworesdlfsadljflzvwuoperjljdfwerlkjaslkdjfianvwqpaqkj\n"
							+ "filename=\"中国1.txt\" name=\"abc\"\n"
							+ "Content-Type: doc/txt\n"
							+ "neirongneirong傲娇非拉科技1\n"
							+ "------websymbolworesdlfsadljflzvwuoperjljdfwerlkjaslkdjfianvwqpaqkj\n"
							+ "filename=\"中国2.txt\" name=\"abc\"\n"
							+ "Content-Type: doc/txt\nneirongneirong傲娇非中艺阿里解放啦捡垃圾的垃圾啊拉科技2\n"
							+ "------websymbolworesdlfsadljflzvwuoperjljdfwerlkjaslkdjfianvwqpaqkj";
			// 边界文本
			final String boundaryText = "------websymbolworesdlfsadljflzvwuoperjljdfwerlkjaslkdjfianvwqpaqkj";
			final int boundaryLength = boundaryText.length();
			int cursor = 0;
			String filename = null;
			String name = null;
			String contentType = null;
			String content = null;
			int textBegin = 0;
			int textEnd = 0;
			int byteBegin = 0;
			int byteEnd = 0;
			
			final int filenameLen = "filename=\"".length();
			final int nameLen = "name=\"".length();
			final int contentTypeLen = "Content-Type: ".length();
			while (cursor < str.length()) {
				// 根据边界文本找到局部
				cursor = str.indexOf(boundaryText , cursor) + boundaryLength;
				if (cursor >= str.length()) {
					//System.out.println(cursor);
					break;
				}
				// 指针移动到下一行
				cursor++;
				// filename
				cursor = str.indexOf("filename=\"", cursor) + filenameLen;
				filename = str.substring(cursor, str.indexOf("\"", cursor));
				// name
				cursor = str.indexOf("name=\"", cursor) + nameLen;
				name = str.substring(cursor, str.indexOf("\"", cursor));
				// 换行
				cursor = str.indexOf("\n", cursor) + 1;
				// Content-Type
				cursor = str.indexOf("Content-Type: ", cursor) + contentTypeLen;
				contentType = str.substring(cursor, str.indexOf("\n", cursor));
				// 指向下一行
				cursor = str.indexOf("\n", cursor) + 1;
				textBegin = cursor;
				// 寻找结束位置
				cursor = str.indexOf(boundaryText, cursor);
				textEnd = cursor;
				byteBegin = str.substring(0, textBegin).getBytes(Constant.CHART_SET_UTF_8).length;
				byteEnd = str.substring(0, textEnd).getBytes(Constant.CHART_SET_UTF_8).length;
				log.info("testFind =====> filename = " + filename + ", name = " + name + ", contentType = " + contentType);
				log.info("testFind =====> textBegin = " + textBegin + ", textEnd = " + textEnd);
				log.info("testFind =====> byteBegin = " + byteBegin + ", byteEnd = " + byteEnd);
			}
			
			//System.out.println(str.length());
			
		} catch (Exception e) {
			log.error("testFind =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSearch() {
		try {
			String str = "";
			
			
			
			
		} catch (Exception e) {
			log.error("testSearch =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testRegex() {
		try {
			String str = "";
			
			
			
			
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
	@Test
	public void testTransfer() {
		try {
			
			
		} catch (Exception e) {
			log.error("testTransfer =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCode() {
		try {
			
			
		} catch (Exception e) {
			log.error("testCode =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testChinese() {
		try {
			
			
		} catch (Exception e) {
			log.error("testChinese =====> ", e);
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
			String str = "中c国a";
			log.info("testTemp =====> " + str.length());
			log.info("testTemp =====> " + str.getBytes(Constant.CHART_SET_UTF_8).length);
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
