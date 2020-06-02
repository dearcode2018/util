/**
  * @filename OrderExMapper.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.mapper;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.hua.dto.OrderQueryDTO;
import com.hua.entity.AddressEntity;
import com.hua.entity.OrderEntity;

/**
 * @type OrderExMapper
 * @description 订单
 * @author qianye.zheng
 */
@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderExMapper {
	
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
	OrderQueryDTO entity2QueryDTO(final OrderEntity entity);
	
	/**
	 * 
	 * @description 实体转换成DTO
	 * @param entity
	 * @return
	 * @author qianye.zheng
	 */
	/** 
	 * 不指定方法名: 同类型同名，使用继承并反转配置，只能用在有一个类型转换的方法里面，有多个则会报错
	 * 此方法，会寻找入参是此方法返回值，出参是此方法入参的方法，只能存在一个.
	 * 
	 * 指定方法名: 指定方法名则可以存在多个同类的转换
	 *  
	 *  */
	@InheritInverseConfiguration(name = "entity2QueryDTO")
	OrderEntity queryDTO2Entity(final OrderQueryDTO dto);
	
	/**
	 * 
	 * @description 
	 * @param entity
	 * @return
	 * @author qianye.zheng
	 */
	@InheritConfiguration(name = "entity2QueryDTO")
	OrderQueryDTO entity2QueryDTOInherit(final OrderEntity entity);
	
	/**
	 * 
	 * @description 默认方法，
	 * 所有入参和返回类型兼容的(set)方法会调用
	 * @param value
	 * @return
	 * @author qianye.zheng
	 */
	 default String trim(final String value) {
		 return value.trim(); 
	 }
	 
	 /**
	  * 
	  * @description 默认方法的场景，适用于 生成器无法执行的场景
	  * 针对特定的类型，此举会成为所有相同方法签名的使用者
	  * @param entity
	  * @return
	  * @author qianye.zheng
	  */
		/*
		 * default OrderQueryDTO defaultEntity2QueryDTO(final OrderEntity
		 * entity) { return new OrderQueryDTO(); }
		 */
	 
	 /**
	  * 
	  * @description 多个入参，名称不同的注意指定source到target的映射
	  * 若入参存在多个同名属性，需要指定映射关系，
	  * @param entity1
	  * @param entity2
	  * @return
	  * @author qianye.zheng
	  */
	@InheritConfiguration(name = "entity2QueryDTO")
	@Mapping(target = "cityName", source = "entity2.city")
	@Mapping(target = "extendFirst", source = "entity1.extend01")
	OrderQueryDTO entity2QueryDTOMulti(final OrderEntity entity1, final AddressEntity entity2);
	
	/**
	 * 
	 * @description 根据入参更新存在的属性，而不返回新的对象
	 * @param address
	 * @param dto
	 * @author qianye.zheng
	 */
	@Mapping(target = "cityName", source = "city")
	void update(final AddressEntity address, @MappingTarget final OrderQueryDTO dto);
	

}
