/**
 * 描述: 
 * MathUtil.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.util;

import java.util.Arrays;

import com.hua.util.StringUtil;

/**
 * 描述: 数学 - 工具类
 * @author  qye.zheng
 * MathUtil
 */
public final class MathUtil
{

	/**
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 */
	private MathUtil()
	{
		
	}

	/**
	 * 
	 * 描述: 生成 [0, factor) 之间随机int型值
	 * 通常使用int型范围的随机数已经能
	 * 满足绝大多数的要求
	 * @author  qye.zheng
	 * @param factor
	 * @return
	 */
	public static int randomNumber(final int factor)
	{
		final int result = (int) (factor * Math.random());
		
		return result;
	}
	
	/**
	 * 
	 * 描述: 随机数字-字符串
	 * @author  qye.zheng
	 * @param length 返回的随机数字-字符长度
	 * @return
	 */
	public static String randomNumberString(final int length)
	{
		/**
		  每一位是 [0, 10) 的随机数字
		  遍历循环length次拼接而成 
		 */
		final int factor = 10;
		String result = null;
		final StringBuilder builder = StringUtil.getBuilder(length);
		for (int i = 0; i < length; i++)
		{
			builder.append(randomNumber(factor));
		}
		result = builder.toString();
		
		return result;
	}
	
}
