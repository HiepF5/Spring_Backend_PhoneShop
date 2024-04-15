package com.example.spring_phoneshop.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class OrderDetailMapper {
    @Autowired
    private ModelMapper modelMapper;
    public OrderDetailDTO toorderdetailDTO (OrderDetail orderdetail){
        OrderDetailDTO orderdetailDTO = modelMapper.map(orderdetail, OrderDetailDTO.class);
        return orderdetailDTO;
    }
}