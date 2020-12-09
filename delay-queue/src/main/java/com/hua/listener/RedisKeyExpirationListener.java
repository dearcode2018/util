/**
  * @filename RedisKeyExpirationListener.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.listener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;


/**
 * @type RedisKeyExpirationListener
 * @description Redis Key 过期监听器
 * @author qianye.zheng
 */
@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {

    /**
     * @description 构造方法
     * @param listenerContainer
     * @author qianye.zheng
     */
    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }
    
    /**
     * @description 
     * @param message
     * @param pattern
     * @author qianye.zheng
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        // __keyevent@*__:expired
        System.out.println("pattern: " + new String(pattern));
        System.out.println("监听key:[ " + message.toString() + " ] 已经过期");
    }
    
}
