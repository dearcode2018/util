package com.hua.mapper;

import com.hua.dto.OrderQueryDTO;
import com.hua.entity.OrderEntity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderQueryDTO entity2QueryDTO(OrderEntity entity) {
        if ( entity == null ) {
            return null;
        }

        OrderQueryDTO orderQueryDTO = new OrderQueryDTO();

        orderQueryDTO.setOrderSn( entity.getOrderSn() );
        orderQueryDTO.setReceiverKeyword( entity.getReceiverKeyword() );
        orderQueryDTO.setStatus( entity.getStatus() );
        orderQueryDTO.setOrderType( entity.getOrderType() );
        orderQueryDTO.setSourceType( entity.getSourceType() );

        return orderQueryDTO;
    }

    @Override
    public OrderQueryDTO entity2QueryDTO2(OrderEntity entity) {
        if ( entity == null ) {
            return null;
        }

        OrderQueryDTO orderQueryDTO = new OrderQueryDTO();

        orderQueryDTO.setOrderSn( entity.getOrderSn() );
        orderQueryDTO.setReceiverKeyword( entity.getReceiverKeyword() );
        orderQueryDTO.setStatus( entity.getStatus() );
        orderQueryDTO.setOrderType( entity.getOrderType() );
        orderQueryDTO.setSourceType( entity.getSourceType() );

        return orderQueryDTO;
    }
}
