/**
  * @filename OrderMapper.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.mapper;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.hua.dto.OrderQueryDTO;
import com.hua.entity.OrderEntity;

/**
 * @type OrderMapper
 * @description 订单
 * @author qianye.zheng
 */
@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {
	
	/**
	 * 日期/时间/数值类型和字符串互转，如果不指定格式，则使用默认的格式来进行转换
	 * 在同名的情况下，直接指定target即可
	 * 
	 * 
	 */
	
	/**
	 * 
	 * @description 实体转换成DTO
	 * @param entity
	 * @return
	 * @author qianye.zheng
	 */
	
	/** 同类型同名，无须配置 */
	OrderQueryDTO entity2QueryDTO(final OrderEntity entity);
	
	/**
	 * 
	 * @description 实体转换成DTO
	 * @param entity
	 * @return
	 * @author qianye.zheng
	 */
    /** 同类型不同名 */
	@Mapping(target = "extendFirst", source = "extend01")
	@Mapping(target = "description", source = "remark")
	OrderQueryDTO entity2QueryDTO2(final OrderEntity entity);
	
	/**
	 * 
	 * @description 实体转换成DTO
	 * @param entity
	 * @return
	 * @author qianye.zheng
	 */
    /** 不同类型同名 */
	@Mapping(target = "dateTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
	@Mapping( target = "date", dateFormat = "yyyy-MM-dd")
	@Mapping(target = "price", numberFormat = "0.00")
	OrderQueryDTO entity2QueryDTO3(final OrderEntity entity);
	
	/**
	 * 
	 * @description 实体转换成DTO
	 * @param entity
	 * @return
	 * @author qianye.zheng
	 */
    /** 不同类型不同名 */
	@Mapping(target = "dateTimeString", source = "dateTimeType", dateFormat = "yyyy-MM-dd HH:mm:ss")
	@Mapping(target = "dateType", source = "dateString", dateFormat = "yyyy-MM-dd")
	OrderQueryDTO entity2QueryDTO4(final OrderEntity entity);
	
	/**
	 * 
	 * @description 实体转换成DTO
	 * @param entity
	 * @return
	 * @author qianye.zheng
	 */
    /** 同类型不同名 */
	@Mapping(target = "extendFirst", source = "extend01")
	@Mapping(target = "description", source = "remark")
    /** 不同类型同名 */
	@Mapping(target = "dateTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
	@Mapping( target = "date", dateFormat = "yyyy-MM-dd")
	@Mapping(target = "price", numberFormat = "0.00")
    /** 不同类型不同名 */
	@Mapping(target = "dateTimeString", source = "dateTimeType", dateFormat = "yyyy-MM-dd HH:mm:ss")
	@Mapping(target = "dateType", source = "dateString", dateFormat = "yyyy-MM-dd")
	OrderQueryDTO entity2QueryDTOFull(final OrderEntity entity);
	
	/**
	 * 
	 * @description 实体转换成DTO
	 * @param entity
	 * @return
	 * @author qianye.zheng
	 */
    /** 表达式 */
	@Mapping(target = "someValueEx", expression = "java(entity.getSomeValue())")
	OrderQueryDTO entity2QueryDTOExpression1(final OrderEntity entity);
	
	/**
	 * 
	 * @description 实体转换成DTO
	 * @param entity
	 * @return
	 * @author qianye.zheng
	 */
    /** 表达式 */
	//@Mapping(target = "someValueEx", expression = "java(setSomething(entity.getSomeValue()))")
	//OrderQueryDTO entity2QueryDTOExpression2(final OrderEntity entity);
	
	 

}
