/**
  * @filename OrderMapper.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.mapper;

import org.mapstruct.Mapper;

import com.hua.dto.OrderQueryDTO;
import com.hua.entity.OrderEntity;

/**
 * @type OrderMapper
 * @description 订单
 * @author qianye.zheng
 */
@Mapper
public interface OrderMapper {
	
	
	/**
	 * 
	 * @description 实体转换成DTO
	 * @param entity
	 * @return
	 * @author qianye.zheng
	 */
	OrderQueryDTO entity2QueryDTO(final OrderEntity entity);
	
	/**
	 * 
	 * @description 实体转换成DTO
	 * @param entity
	 * @return
	 * @author qianye.zheng
	 */
	OrderQueryDTO entity2QueryDTO2(final OrderEntity entity);

}
