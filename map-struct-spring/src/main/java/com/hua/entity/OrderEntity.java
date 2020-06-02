/**
  * @filename OrderEntity.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.entity;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * @type OrderEntity
 * @description 订单
 * @author qianye.zheng
 */
@Data
public class OrderEntity {
	
	/** 同类型同名，无须配置 */
	/* 订单id */
    private Long id;
    
    /* 订单编号 */
    private String orderSn;
    
    /*  收货人姓名/号码 */
    private String receiverKeyword;
    
    /*  订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单 */
    private Integer status;
    
    /* n订单类型：0->正常订单；1->秒杀订单 */
    private Integer orderType;
    
    /* 订单来源：0->PC订单；1->app订单 */
    private Integer sourceType;
    
    /** 同类型不同名 */
    private String extend01;
    
    private String remark;
    
    /** 不同类型同名 */
    private LocalDateTime dateTime;
    
    private String date;
    
    private double price;
    
    /** 不同类型不同名 */
    private LocalDateTime dateTimeType;
    
    private String dateString;
    
    /** 表达式 */
    private String someValue;
	
}
