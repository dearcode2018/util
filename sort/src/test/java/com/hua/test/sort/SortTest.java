/**
 * 描述: 
 * SortTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.sort;

import net.sourceforge.pinyin4j.PinyinHelper;

import org.junit.Test;

import com.hua.test.BaseTest;
import com.hua.util.PinyinComparator;
import com.hua.util.SortUtil;

/**
 * 描述: 
 * 
 * @author qye.zheng
 * SortTest
 */
public final class SortTest extends BaseTest {
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testTemp() {
		try {
			int[] array = {1, 2, 3, 4, 5};
			int target = 10;
			
			log.info("testTemp =====> " + SortUtil.binarySearch(array, target));
			
		} catch (Exception e) {
			log.error("testTemp =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testPinyin() {
		try {
			String[] str = PinyinHelper.toHanyuPinyinStringArray('中');
			for (int i = 0; i < str.length; i++) {
				log.info("testPinyin=====> " + str[i]);
			}
		} catch (Exception e) {
			log.error("testPinyin =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSort() {
		try {
			final PinyinComparator comp = new PinyinComparator();
			final String str1 = "中国真大";
			final String str2 = "世界真蓝";
			log.info("testSort=====> result = " + comp.compare(str1, str2));
			
		} catch (Exception e) {
			log.error("testSort =====> ", e);
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
	public void testSimple() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSimple =====> ", e);
		}
	}
}
