/**
 * PinyinUtil.java
 * @author qye.zheng
 * 
 * 	version 1.0
 */
package com.hua.util;

import com.hua.util.StringUtil;

import net.sourceforge.pinyin4j.PinyinHelper;

/**
 * PinyinUtil
 * 描述: 
 * @author qye.zheng
 * 
 */
public final class PinyinUtil
{

	/**
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	private PinyinUtil()
	{
	}

	
	/**
	 * 
	 * 描述: 返回多个汉字的首字母
	 * @author qye.zheng
	 * 
	 * @param words 汉字词语
	 * @return
	 */
	public static String getPinyinAleph(final String words) {
		if (StringUtil.isEmpty(words)) {
			return null;
		}
		final char[] wordArray = words.toCharArray();
		final StringBuilder builder = StringUtil.getBuilder();
		for (int i = 0; i < wordArray.length; i++)
		{
			// 取首字母，例如 中 : zhong1 --> z
			// 获取第一组拼音(存在多音字，然后在获取第一个字母)
			String[] ss = PinyinHelper.toHanyuPinyinStringArray(wordArray[i]);
			if (ss != null && ss.length != 0)
			{
				builder.append(ss[0].charAt(0));
			} else
			{
				builder.append((wordArray[i]));
			}
		}
		
		return builder.toString();
	}
	
	/**
	 * 
	 * 描述: 返回单个汉字的首字母
	 * @author qye.zheng
	 * 
	 * @param word 单个汉字
	 * @return
	 */
	public static char getPinyinAleph(final char word) {
		
		return PinyinHelper.toHanyuPinyinStringArray(word)[0].charAt(0);
	}
	
}
