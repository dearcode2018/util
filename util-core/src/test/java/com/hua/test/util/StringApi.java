/**
 * StringApi.java
 * @author qye.zheng
 * 
 * 	version 1.0
 */
package com.hua.test.util;

import org.junit.Test;

import com.hua.constant.Constant;
import com.hua.test.BaseTest;

/**
 * StringApi
 * 
 * java.lang.String
 * 
 * 描述: 
 * @author qye.zheng
 * 
 */
public final class StringApi extends BaseTest
{
	
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
}
