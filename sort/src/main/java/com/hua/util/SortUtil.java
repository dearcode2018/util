/**
 * 描述: 
 * SortUtil.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.util;

import com.hua.constant.Constant;

/**
 * 描述: 
 * 
 * @author qye.zheng
 * SortUtil
 */
public final class SortUtil {
	
	/** 无参构造方法 */
	private SortUtil() {}
	
	/**
	 排序: 
	 覆盖equals、hashCode、Comparable<T>.compareTo方法、
	 方法，然后执行排序动作
	 
	 
	 */
	
	/**
	 二分法:
	 
	 
	 
	 
	 
	 
	 
	 */
	
	/**
	 * 注意: 在调用二分法查找之前，确保数组经过排序
	 * 描述: 二分法查找 
	 * @author  qye.zheng
	 * @param array
	 * @return
	 */
	public static int binarySearch(final int[] array, int target)
	{
		int startIndex = 0;
		int endIndex = array.length - 1;
		int middle = 0;
		while (startIndex <= endIndex)
		{
			// 计算中间下标
			middle = (endIndex + startIndex) / 2;
			if (target == array[middle])
			{
				return middle;
			}
			if (target < array[middle])
			{
				// 前半部分
				endIndex = middle - 1;
			} else if (target > array[middle])
			{
				// 后半部分
				startIndex = middle + 1;
			}
		}
		// 返回 -1
		return Constant.NEGATIVE_ONE;
	}
	
}
