/**
 * RegexConstant.java
 * @author qye.zheng
 * 
 * 	version 1.0
 */
package com.hua.constant;

/**
 * RegexConstant
 * 描述: 正则 - 常量
 * @author qye.zheng
 * 
 */
public interface RegexConstant
{

	// 数字
	String NUMBER_REGEX = "\\d";
	
	// 包含数字
	String HAS_NUMBER = "[\\s\\S]*(\\d+)[\\s\\S]*";
	
	// 英文
	
	// MAC 地址
	 String MAC_REGEX = "^([0-9a-fA-F]{2})(([0-9a-fA-F]{2}){5})$";
	 
	 // 标签 (<a></a>)
	 String TAG_REGEX = "</?\\w+.*?>";
	 
	 
	 // 任意单个字符(包括空白字符/换行符)
	 String ANY_CHAR_REGEX = "[\\s\\S]";
	 
	 // 任意字符串
	 String ANY_STRING_REGEX = "[\\s\\S]*";
	 
	 // 空白字符(包括\n\r\f\t\v)
	 String WHITE_CHAR_REGEX = "\\s";
	 
	 
}
