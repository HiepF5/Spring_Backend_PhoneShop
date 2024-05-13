package com.example.spring_phoneshop.mapper;

import com.example.spring_phoneshop.dto.OrdersDTO;
import com.example.spring_phoneshop.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class OrdersMapper {
    @Autowired
    private ModelMapper modelMapper;
    public OrdersDTO mapToOrdersDTO(Orders orders){
        OrdersDTO ordersDTO = modelMapper.map(orders, OrdersDTO.class);
        return ordersDTO;
    }
    public Orders mapToOrdersEntity (OrdersDTO ordersDTO) {
        Orders orders = modelMapper.map(ordersDTO, Orders.class);
        return orders;
    }
}
