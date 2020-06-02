/**
  * @filename OrderQueryDTO.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.dto;

import java.time.LocalDate;

import lombok.Data;

/**
 * @type OrderQueryDTO
 * @description 订单查询
 * @author qianye.zheng
 */
@Data
public class OrderQueryDTO {

	/** 同类型同名 */
    /* 订单编号 */
    private String orderSn;
    
    /* 收货人姓名/号码 */
    private String receiverKeyword;
    
    /*  订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单 */
    private Integer status;
    
    /* 订单类型：0->正常订单；1->秒杀订单 */
    private Integer orderType;
    
    /* 订单来源：0->PC订单；1->app订单 */
    private Integer sourceType;
    
    /** 同类型不同名 */
    private String extendFirst;
    
    private String description;
    
    /** 不同类型同名 */
    private String dateTime;
    
    private LocalDate date;
    
    private String price;
   
    /** 不同类型不同名 */
    private String dateTimeString;
    
    private LocalDate dateType;
    
    /** 表达式 */
    private String someValueEx;
    
    /** 来自多个实体 */
	private String province;
	
	private String cityName;
	
    
	
}
