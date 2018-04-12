/**
  * @filename SensitiveWordFilter.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.filte;

import java.util.Map;

 /**
 * @type SensitiveWordFilter
 * @description 敏感词过滤器
 * @author qianye.zheng
 */
public class SensitiveWordFilter
{
	/** 最小匹配规则 */
	public static final int MIN_MATCH_TYPE = 1;
	
	/** 最大匹配规则 */
	public static final int MAX_MATCH_TYPE = 2;
	
	private static Map<Object, Object> sensitiveWordMap;
	
	static
	{
		sensitiveWordMap = SensitiveWrodInit.init();
	}
	
	/**
	 * 
	 * @description 
	 * @param text
	 * @return
	 * @author qianye.zheng
	 */
	public static final boolean isContainSensitiveWord(final String text)
	{
		boolean flag = false;
		int matchResult = 0;
		for (int i = 0; i < text.length(); i++)
		{
			// 只是判断是否存在，使用最小匹配规则即可满足
			matchResult = checkSensitiveWord(text, i, MIN_MATCH_TYPE);
			if (matchResult > 0)
			{
				flag = true;
				// 直接结束
				break;
			}
		}
		
		return flag;
	}
	
	/**
	 * 
	 * @description 敏感字符串检查
	 * @param text 文本字符串
	 * @param beginIndex 起始索引
	 * @param matchType 匹配类型
	 * @return
	 * @author qianye.zheng
	 */
	@SuppressWarnings({"unchecked"})
	private static final int checkSensitiveWord(final String text, final int beginIndex, final int matchType)
	{
		// 敏感词结束标志位: 用于敏感词只有1位的情况
		boolean flag = false;
		// 匹配标志数
		int matchFlag = 0;
		// 字
		char word = 0;
		Map<Object, Object> nowMap = sensitiveWordMap;
		for (int i = beginIndex; i < text.length(); i++)
		{
			word = text.charAt(i);
			// 获取指定的key
			nowMap = (Map<Object, Object>) nowMap.get(word);
			if (null != nowMap)
			{
				// 找到相应key，匹配标识符自增，统计找到的长度
				matchFlag++;
				if ("1".equals(nowMap.get("isEnd")))
				{ // 如果为最后一个匹配规则，结束循环
					// 结束标志位设置为true
					flag = true;
					// 若是最小规则，则不再往下找，直接结束，最大规则是找不到为止
					if (MIN_MATCH_TYPE == matchType)
					{
						break;
					}
				}
			} else
			{ // 不存在，直接返回
				break;
			}
		}
		if (matchFlag < 2 || !flag)
		{
			matchFlag = 0;
		}
		
		return matchFlag;
	}
}
