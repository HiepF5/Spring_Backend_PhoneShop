package com.example.spring_phoneshop.mapper;

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
    public OrdersDTO toordersDTO(Orders orders){
        OrdersDTO ordersDTO = modelMapper.map(orders, OrdersDTO.class);
        return ordersDTO;
    }
}
