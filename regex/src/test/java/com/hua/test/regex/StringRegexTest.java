/**
 * 描述: 
 * StringRegexTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.regex;

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

import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * StringRegexTest
 */
public final class StringRegexTest extends BaseTest {
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testStringRegex() {
		try {
			
			target = "ab1b";
			
			
		} catch (Exception e) {
			log.error("testStringRegex =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testMatch() {
		try {

			
		} catch (Exception e) {
			log.error("testMatch =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 匹配任何字类字符，包括下划线
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testMatchWord() {
		try {
			
			/**
			  匹配任何字类字符，包括下划线
			 注意，word 这里翻译为字，而不是单词
			 */
			regex = "(\\w)+";
			
			// 字母/数字/下划线
			target = "a1_";
			
			matches = target.matches(regex);
			log.info("testMatchWord =====>(字母/数字/下划线) matches = " + matches);
			
			// 含有中划线，不匹配
			target = "a1-";
			matches = target.matches(regex);
			log.info("testMatchWord =====> (含有中划线，不匹配) matches = " + matches);
			
			// 含有非字字符，不匹配
			target = "a1,";
			matches = target.matches(regex);
			log.info("testMatchWord =====> (含有非字字符，不匹配) matches = " + matches);
			
		} catch (Exception e) {
			log.error("testMatchWord =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 匹配任何非字类字符
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testMatchNoWord() {
		try {
			
			/**
			  匹配任何非字类字符
			 注意，word 这里翻译为字，而不是单词
			 */
			regex = "(\\W)+";
			
			// 字母/数字/下划线
			target = "a1_";
			
			matches = target.matches(regex);
			log.info("testMatchNoWord =====>(字母/数字/下划线 不匹配) matches = " + matches);
			
			// 不含有字类字符
			target = ",\\-%";
			matches = target.matches(regex);
			log.info("testMatchNoWord =====>(不含有字类字符) matches = " + matches);
			
		} catch (Exception e) {
			log.error("testMatchNoWord =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 数字字符
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testNumber() {
		try {
			regex = "(\\d)+";
			// 纯数字字符
			target = "2029293";
			matches = target.matches(regex);
			log.info("testNumber =====> 纯数字字符 matches = " + matches);
			
			// 含有非数字字符
			target = "a12,";
			matches = target.matches(regex);
			log.info("testNumber =====> 含有非数字字符 matches = " + matches);
		} catch (Exception e) {
			log.error("testNumber =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 非数字字符
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testNoNumber() {
		try {
			regex = "(\\D)+";
			// 纯数字字符
			target = "2029293";
			matches = target.matches(regex);
			log.info("testNoNumber =====> 纯数字字符 matches = " + matches);
			
			// 含有非数字字符
			target = "a12,";
			matches = target.matches(regex);
			log.info("testNoNumber =====> 含有非数字字符 matches = " + matches);
			
			// 全部是非数字字符
			target = "ah([,";
			matches = target.matches(regex);
			log.info("testNoNumber =====> 全部是非数字字符 matches = " + matches);
			
		} catch (Exception e) {
			log.error("testNoNumber =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 匹配空白字符
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testWhiteChar() {
		try {
			/*
			 空格、制表符、垂直制表符、换页符、换行符、回车符
			 \t \v(无法识别) \f \n \r
			 */
			regex = "\\s";
			// 含一个空白字符
			target = " ";
			matches = target.matches(regex);
			log.info("testWhiteChar  =====> 含一个空白字符 matches = " + matches);
			
			// 含多个空白字符
			target = "  ";
			matches = target.matches(regex);
			log.info("testWhiteChar  =====> 含多个空白字符 matches = " + matches);
			
			
			// 换行符
			target = "\n";
			//target = "\\v";
			//target = "\t";
			 
			matches = target.matches(regex);
			log.info("testWhiteChar  =====> 换行符 matches = " + matches);
			
		} catch (Exception e) {
			log.error("testWhiteChar =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 匹配非空白字符
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testNoWhiteChar() {
		try {
			regex = "\\S";
			target = " ";
			
			
			
		} catch (Exception e) {
			log.error("testNoWhiteChar =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDot() {
		try {
			
			/*
			 . 匹配 除了 [换行符、回车符] 之外的任何字符
			 
			 即不匹配: 换行符、回车符(\n 和 \r 可视为同一个字符)
			 */
			regex = ".";
			
			// 空格
			target = " ";
			matches = target.matches(regex);
			log.info("testDot =====> 匹配空格 matches = " + matches);
			
			// 换行符
			target = "\n";
			matches = target.matches(regex);
			log.info("testDot =====> 换行符 (不匹配) matches = " + matches);
			
			// 回车符
			target = "\r";
			matches = target.matches(regex);
			log.info("testDot =====> 回车符 (不匹配) matches = " + matches);
			
			// 换页符
			target = "\f";
			matches = target.matches(regex);
			log.info("testDot =====> 换页符 (匹配) matches = " + matches);
			
			// 制表符
			target = "\t";
			matches = target.matches(regex);
			log.info("testDot =====> 制表符 (匹配) matches = " + matches);
			
		} catch (Exception e) {
			log.error("testDot =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 匹配任意字符
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testAnyChar() {
		try {
			
			/*
			 . 除了换行符、回车符之外的任何字符
			\S 除了空格、制表符、垂直制表符、换页符、换行符、回车符之外的任何字符
			\s 空格、制表符、垂直制表符、换页符、换行符、回车符 (空白字符)
			匹配任意字符 [\s\S]
			 */
			// 匹配任意多个字符
			regex = "[\\s\\S]+";
			
			// 多个任意字符
			target = "a~!@#$%^&*()_ +=-0[]{};:'\",.<>/?\\|A`\r\n\f\t";
			matches = target.matches(regex);
			log.info("testAnyChar =====> 多个任意字符 matches = " + matches);
			
		} catch (Exception e) {
			log.error("testAnyChar =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBoundary() {
		try {
			/*
			 \b 匹配一个字边界，即字与空格间的位置。
			 即匹配字的结尾部分的，但不匹配字的开头部分.
			 
			 
			 注意，在String中 \b 可以直接书写，但是表示的不是这个意思
			 应该写成 \\b
			 */
		
			// 开头部分无匹配
			 regex = "a1\\b[\\s\\S]*";
			 target = "a1mi";
			 matches = target.matches(regex);
			 log.info("testBoundary =====> 开头边界 (不匹配) matches = " + matches);
			 
			 // 匹配字的结尾部分
			 regex = "[\\s\\S]*a1_\\b";
			 target = "mia1_";
			 matches = target.matches(regex);
			 log.info("testBoundary =====> 结尾边界 matches = " + matches);
			 
			 regex = "[\\s\\S]*er\\b";
			 target = "never";
			 matches = target.matches(regex);
			 log.info("testBoundary =====> never matches = " + matches);
			 
			 regex = "[\\s\\S]*er\\b";
			 target = "verb";
			 matches = target.matches(regex);
			 log.info("testBoundary =====> verb matches = " + matches);
			 
		} catch (Exception e) {
			log.error("testBoundary =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testNoBoundary() {
		try {
			/*
			 \B 匹配一个字非边界，即中间的位置。
			 
			 */
	
			 regex = "[\\s\\S]*er\\B[\\s\\S]*";
			 target = "never";
			 matches = target.matches(regex);
			 log.info("testBoundary =====> matches = " + matches);
			 
			 regex = "[\\s\\S]*er\\B[\\s\\S]*";
			 target = "verb";
			 matches = target.matches(regex);
			 log.info("testBoundary =====> matches = " + matches);
			 
		} catch (Exception e) {
			log.error("testNoBoundary =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testEmptyString() {
		try {
			
			regex = "[\\s\\S]";
			// 空字符串
			target = "";
			matches = target.matches(regex);
			log.info("testEmptyString =====> matches = " + matches);
			 
			regex = "[\\s\\S]*";
			// 空字符串
			target = "";
			matches = target.matches(regex);
			log.info("testEmptyString =====> matches = " + matches);
			
			regex = "[\\s\\S]{0}";
			// 空字符串
			target = "";
			matches = target.matches(regex);
			log.info("testEmptyString =====> matches = " + matches);
			
			regex = "[\\s\\S]?";
			// 空字符串
			target = "";
			matches = target.matches(regex);
			log.info("testEmptyString =====> matches = " + matches);
			
		} catch (Exception e) {
			log.error("testEmptyString =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 模式次数
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testTimes() {
		try {
			
			/*
			 模式次数
			 * ? +
			 {n,m}
			 {n}
			 {n, }
			 */
			regex = "[\\s\\S]*";
			target = "";
			matches = target.matches(regex);
			log.info("testTimes =====> matches = " + matches);
			
			regex = "[\\s\\S]+";
			target = "a";
			matches = target.matches(regex);
			log.info("testTimes =====> matches = " + matches);
			
			regex = "[\\s\\S]?";
			target = "";
			matches = target.matches(regex);
			log.info("testTimes =====> matches = " + matches);
			
			regex = "[\\s\\S]{2}";
			target = "abv";
			matches = target.matches(regex);
			log.info("testTimes =====> matches = " + matches);
			
			
		} catch (Exception e) {
			log.error("testTimes =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 匹配起始字符
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testStartPosition() {
		try {
			/*
			 匹配起始字符
			 以^开头的正则
			 */
			regex = "^start[\\s\\S]*";
			target = "start";
			matches = target.matches(regex);
			log.info("testStartPosition =====> start matches = " + matches);
			
			regex = "^start[\\s\\S]*";
			target = "startB";
			matches = target.matches(regex);
			log.info("testStartPosition =====> startB matches = " + matches);
			
			regex = "^start[\\s\\S]*";
			target = "Astart";
			matches = target.matches(regex);
			log.info("testStartPosition =====> Astart matches = " + matches);
			
			regex = "^start[\\s\\S]*";
			target = "AstartB";
			matches = target.matches(regex);
			log.info("testStartPosition =====> AstartB matches = " + matches);
			
			
		} catch (Exception e) {
			log.error("testStartPosition =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 匹配结尾字符
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testEndPosition() {
		try {
			/*
			 匹配结尾字符
			 以$结尾的正则
			 */
			regex = "[\\s\\S]*end$";
			target = "end";
			matches = target.matches(regex);
			log.info("testEndPosition =====> end matches = " + matches);
			
			regex = "[\\s\\S]*end$";
			target = "Aend";
			matches = target.matches(regex);
			log.info("testEndPosition =====> Aend matches = " + matches);
			
			regex = "[\\s\\S]*end$";
			target = "endB";
			matches = target.matches(regex);
			log.info("testEndPosition =====> endB matches = " + matches);
			
			regex = "[\\s\\S]*end$";
			target = "AendB";
			matches = target.matches(regex);
			log.info("testEndPosition =====> AendB matches = " + matches);
			
		} catch (Exception e) {
			log.error("testEndPosition =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 反向引用
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testReverseQuote() {
		try {
			
			/*
			 注意 \num，在String中也是可以直接表示的，
			 不能直接写，需要将正则完整转成字符串形式
			 \num num是一个正整数，到捕获匹配的反向引用.
			 */
			
			// \1前面有一个捕获子表达式
			regex = "(\\w)\\1";
			
			target = "ab";
			matches = target.matches(regex);
			log.info("testReverseQuote =====> matches = " + matches);
			
			regex = "(\\w)\\1";
			target = "aa";
			matches = target.matches(regex);
			log.info("testReverseQuote =====> matches = " + matches);
			
			// 匹配3个连续相同的字类字符
			regex = "[\\s\\S]*(\\w)\\1{2}[\\s\\S]*";
			target = "aaab";
			matches = target.matches(regex);
			log.info("testReverseQuote =====> matches = " + matches);
			
		} catch (Exception e) {
			log.error("testReverseQuote =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testOptions() {
		try {
			
			/**
			 选项: 从指定的选项中选择一个
			 中括号内加^，表示整体非
			 [a-z]
			 [^a-z]
			 [A-Z]
			 [a-zA-Z0-9]
			 [0-9]
			 [abc]
			 [^abc]
			 */
			// 匹配 a和b a和c b和c 组成的各种不考虑顺序的值
			regex = "[abc]{2}";
			
			target = "ab";
			target = "ac";
			target = "bc";
			target = "ca";
			matches = target.matches(regex);
			log.info("testOptions =====> matches = " + matches);
			
			
			
		} catch (Exception e) {
			log.error("testOptions =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testOr() {
		try {
			
			/*
			 | 或者
			 a|b 等效于 [ab]
			 中括号里面就是表示或
			 */
			regex = "a|b";
			target = "a";
			matches = target.matches(regex);
			log.info("testOr =====> matches = " + matches);
			
			regex = "a|b";
			target = "b";
			matches = target.matches(regex);
			log.info("testOr =====> matches = " + matches);
			
			regex = "a|b";
			target = "c";
			matches = target.matches(regex);
			log.info("testOr =====> matches = " + matches);
			
		} catch (Exception e) {
			log.error("testOr =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testHexadecimal() {
		try {
			
			/*
			 \xhh 2位十六进制表示的ANSCII字符 (由8位的 byte表示的ASCII码)
			 */
			
			// 表示字符 A
			regex = "\\x41";
			target = "A";
			matches = target.matches(regex);
			log.info("testHexadecimal =====> matches = " + matches);
			
		} catch (Exception e) {
			log.error("testHexadecimal =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testUnicode() {
		try {
			/**
			下面的反斜杠其实只有1个，为了规避编译器报错，多加了一个.
			 \\uhhhh 4位16进制表示的Unicode字符(16为 character)
			 */
			
			// 表示字符 A
			regex = "\\u0041";
			target = "A";
			matches = target.matches(regex);
			log.info("testUnicode =====> matches = " + matches);
			
		} catch (Exception e) {
			log.error("testUnicode =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testPattern() {
		try {
			/**
			 (pattern) 匹配 pattern 并捕获该匹配的子表达式。
			 可以使用 $0…$9 属性从结果“匹配”集合中检索捕获的匹配。若要匹配括号字符 ( )，请使用“\(”或者“\)”。
			 
			 (?:pattern) 匹配 pattern 但不捕获该匹配的子表达式，即它是一个非捕获匹配，不存储供以后使用的匹配。
			 这对于用“or”字符 (|) 组合模式部件的情况很有用。例如，'industr(?:y|ies) 是比 'industry|industries' 更经济的表达式。
			 
			 (?=pattern) 执行正向预测先行搜索的子表达式，该表达式匹配处于匹配 pattern 的字符串的起始点的字符串。
			 它是一个非捕获匹配，即不能捕获供以后使用的匹配。
			 例如，'Windows (?=95|98|NT|2000)' 匹配“Windows 2000”中的“Windows”，但不匹配“Windows 3.1”中的“Windows”。
			 预测先行不占用字符，即发生匹配后，下一匹配的搜索紧随上一匹配之后，而不是在组成预测先行的字符后。
			 
			(?!pattern) 执行反向预测先行搜索的子表达式，该表达式匹配不处于匹配 pattern 的字符串的起始点的搜索字符串。
			它是一个非捕获匹配，即不能捕获供以后使用的匹配。
			例如，'Windows (?!95|98|NT|2000)' 匹配“Windows 3.1”中的 “Windows”，但不匹配“Windows 2000”中的“Windows”。
			预测先行不占用字符，即发生匹配后，下一匹配的搜索紧随上一匹配之后，而不是在组成预测先行的字符后。
			
			 */
			
			
			
		} catch (Exception e) {
			log.error("testPattern =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testPatternOne() {
		try {
			/**
			 (pattern) 匹配 pattern 并捕获该匹配的子表达式。
			 可以使用 $0…$9 属性从结果“匹配”集合中检索捕获的匹配。若要匹配括号字符 ( )，请使用“\(”或者“\)”。
			 
			 (?:pattern) 匹配 pattern 但不捕获该匹配的子表达式，即它是一个非捕获匹配，不存储供以后使用的匹配。
			 这对于用“or”字符 (|) 组合模式部件的情况很有用。例如，'industr(?:y|ies) 是比 'industry|industries' 更经济的表达式。
			 
			 (?=pattern) 执行正向预测先行搜索的子表达式，该表达式匹配处于匹配 pattern 的字符串的起始点的字符串。
			 它是一个非捕获匹配，即不能捕获供以后使用的匹配。
			 例如，'Windows (?=95|98|NT|2000)' 匹配“Windows 2000”中的“Windows”，但不匹配“Windows 3.1”中的“Windows”。
			 预测先行不占用字符，即发生匹配后，下一匹配的搜索紧随上一匹配之后，而不是在组成预测先行的字符后。
			 
			(?!pattern) 执行反向预测先行搜索的子表达式，该表达式匹配不处于匹配 pattern 的字符串的起始点的搜索字符串。
			它是一个非捕获匹配，即不能捕获供以后使用的匹配。
			例如，'Windows (?!95|98|NT|2000)' 匹配“Windows 3.1”中的 “Windows”，但不匹配“Windows 2000”中的“Windows”。
			预测先行不占用字符，即发生匹配后，下一匹配的搜索紧随上一匹配之后，而不是在组成预测先行的字符后。
			
			 */
			
			
			
		} catch (Exception e) {
			log.error("testPatternOne =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testPatternTwo() {
		try {
			/**
			 (pattern) 匹配 pattern 并捕获该匹配的子表达式。
			 可以使用 $0…$9 属性从结果“匹配”集合中检索捕获的匹配。若要匹配括号字符 ( )，请使用“\(”或者“\)”。
			 
			 (?:pattern) 匹配 pattern 但不捕获该匹配的子表达式，即它是一个非捕获匹配，不存储供以后使用的匹配。
			 这对于用“or”字符 (|) 组合模式部件的情况很有用。例如，'industr(?:y|ies) 是比 'industry|industries' 更经济的表达式。
			 
			 (?=pattern) 执行正向预测先行搜索的子表达式，该表达式匹配处于匹配 pattern 的字符串的起始点的字符串。
			 它是一个非捕获匹配，即不能捕获供以后使用的匹配。
			 例如，'Windows (?=95|98|NT|2000)' 匹配“Windows 2000”中的“Windows”，但不匹配“Windows 3.1”中的“Windows”。
			 预测先行不占用字符，即发生匹配后，下一匹配的搜索紧随上一匹配之后，而不是在组成预测先行的字符后。
			 
			(?!pattern) 执行反向预测先行搜索的子表达式，该表达式匹配不处于匹配 pattern 的字符串的起始点的搜索字符串。
			它是一个非捕获匹配，即不能捕获供以后使用的匹配。
			例如，'Windows (?!95|98|NT|2000)' 匹配“Windows 3.1”中的 “Windows”，但不匹配“Windows 2000”中的“Windows”。
			预测先行不占用字符，即发生匹配后，下一匹配的搜索紧随上一匹配之后，而不是在组成预测先行的字符后。
			
			 */
			
		} catch (Exception e) {
			log.error("testPatternTwo =====> ", e);
		}
	}

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testStringTemp() {
		try {
			// 匹配任意非空白字符串
			regex = "\\S+";
			// 含一个空白字符
			target = "/a/b/c";
			//target = " ";
			matches = target.matches(regex);
			log.info("testWhiteChar  =====> matches = " + matches);
			
		} catch (Exception e) {
			log.error("testStringTemp =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testPatternThree() {
		try {
			/**
			 (pattern) 匹配 pattern 并捕获该匹配的子表达式。
			 可以使用 $0…$9 属性从结果“匹配”集合中检索捕获的匹配。若要匹配括号字符 ( )，请使用“\(”或者“\)”。
			 
			 (?:pattern) 匹配 pattern 但不捕获该匹配的子表达式，即它是一个非捕获匹配，不存储供以后使用的匹配。
			 这对于用“or”字符 (|) 组合模式部件的情况很有用。例如，'industr(?:y|ies) 是比 'industry|industries' 更经济的表达式。
			 
			 (?=pattern) 执行正向预测先行搜索的子表达式，该表达式匹配处于匹配 pattern 的字符串的起始点的字符串。
			 它是一个非捕获匹配，即不能捕获供以后使用的匹配。
			 例如，'Windows (?=95|98|NT|2000)' 匹配“Windows 2000”中的“Windows”，但不匹配“Windows 3.1”中的“Windows”。
			 预测先行不占用字符，即发生匹配后，下一匹配的搜索紧随上一匹配之后，而不是在组成预测先行的字符后。
			 
			(?!pattern) 执行反向预测先行搜索的子表达式，该表达式匹配不处于匹配 pattern 的字符串的起始点的搜索字符串。
			它是一个非捕获匹配，即不能捕获供以后使用的匹配。
			例如，'Windows (?!95|98|NT|2000)' 匹配“Windows 3.1”中的 “Windows”，但不匹配“Windows 2000”中的“Windows”。
			预测先行不占用字符，即发生匹配后，下一匹配的搜索紧随上一匹配之后，而不是在组成预测先行的字符后。
			
			 */
			
		} catch (Exception e) {
			log.error("testPatternThree =====> ", e);
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
