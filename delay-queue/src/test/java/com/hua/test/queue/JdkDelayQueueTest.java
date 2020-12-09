/**
 * 描述: 
 * JdkDelayQueueTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.queue;

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

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.hua.test.BaseTest;

import lombok.Data;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * JdkDelayQueueTest
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
public final class JdkDelayQueueTest extends BaseTest {

	
    /**
     * 
     * 描述: 
     * @author qye.zheng
     * 
     */
    //@DisplayName("test")
    @Test
    public void testDelayQueue() {
        try {
            DelayQueue<Order> delayQueue = new DelayQueue<>();
            Order order1 = new Order("订单1-延时 10秒", 10, TimeUnit.SECONDS);
            delayQueue.add(order1);
            
            Order order2 = new Order("订单2-延时 20秒", 20, TimeUnit.SECONDS);
            delayQueue.add(order2);
            
            Order order3= new Order("订单3-延时 30秒", 40, TimeUnit.SECONDS);
            delayQueue.add(order3);
            
            // 消费队列
            while (delayQueue.size() > 0) { // 若是队列会不定期放元素，则应该使用 无限循环 while (true) {}
                // 阻塞直到有元素延时达到，DelayQueue 已经实现了等待
                Order order = delayQueue.take();
                // 业务逻辑
                order.consume();
            }
            
        } catch (Exception e) {
            log.error("test =====> ", e);
        }
    }
    
    /**
     * 
     * @type Order
     * @description 
     * @author qianye.zheng
     */
    @Data
    class Order implements Delayed {
        
        /* 名称 */
        private String name;
        
        /* 执行时间戳，单位: 毫秒 */
        private long execTimestamp;
        
        /**
         * 
         * @description 构造方法
         * @param name
         * @param delay
         * @param unit
         * @author qianye.zheng
         */
        Order(final String name, final long delay, final TimeUnit unit) {
            this.name = name;
            this.execTimestamp = System.currentTimeMillis() + unit.toMillis(delay);
        }
        
        /**
         * @description 排序
         * 在延时队列中的排序，越早执行的越排在签名
         * DelayQueue 会据此来 poll() 出元素
         * @param o
         * @return
         * @author qianye.zheng
         */
        @Override
        public int compareTo(Delayed o) {
            // 小于等于玩后排
            final Order other = (Order) o;
            int result = -1;
            if (this.execTimestamp - other.execTimestamp > 0) {
                result = 1;
            }
            
            return result;
        }
        
        /**
         * @description 还剩下多长时间，单位: 毫秒
         * @param unit
         * @return
         * @author qianye.zheng
         */
        @Override
        public long getDelay(TimeUnit unit) {
            return execTimestamp - System.currentTimeMillis();
        }
        
        /**
         * 
         * @description 
         * @author qianye.zheng
         */
        public void consume() {
            System.out.println("订单: " + name + ", 已完成");
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
	@DisplayName("testTemp")
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
		
	}

}
