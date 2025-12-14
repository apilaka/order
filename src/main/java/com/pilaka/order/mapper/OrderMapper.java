package com.pilaka.order.mapper;
import com.pilaka.order.dto.OrderDTO;
import com.pilaka.order.dto.OrderDTOFromFE;
import com.pilaka.order.dto.Restaurant;
import com.pilaka.order.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    Order mapOrderDTOFromFEToOrder(OrderDTOFromFE dto);

    OrderDTO mapOrderToOrderDTO(Order order);

}