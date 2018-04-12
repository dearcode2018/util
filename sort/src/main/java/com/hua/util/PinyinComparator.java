/**
 * 描述: 
 * PinyinComparator.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.util;

import java.util.Comparator;

import net.sourceforge.pinyin4j.PinyinHelper;

import com.hua.constant.Constant;

/**
 * 描述: 
 * 
 * @author qye.zheng
 * PinyinComparator
 */
public final class PinyinComparator implements Comparator<String> {

	 /**
	 * 描述: 
	 * @author qye.zheng
	 * 
	 * @param o1
	 * @param o2
	 * @return
	 */
	@Override
	public int compare(final String first, final String second) {
		// 取字符串的第一个字符
		final char c1 = first.charAt(Constant.ZERO);
		final char c2 = second.charAt(Constant.ZERO);
		// 只获取第一个 拼音和声调
		final String str1 = PinyinHelper.toHanyuPinyinStringArray(c1)[0];
		final String str2 = PinyinHelper.toHanyuPinyinStringArray(c2)[0];
		
		return str1.compareTo(str2);
	}

	
}
