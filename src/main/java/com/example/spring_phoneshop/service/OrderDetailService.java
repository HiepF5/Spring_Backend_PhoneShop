package com.example.spring_phoneshop.service;

import com.example.spring_phoneshop.entity.OrderDetail;
import com.example.spring_phoneshop.dto.OrderDetailDTO;

import java.util.List;
import java.util.Optional;

public interface OrderDetailService {
    List<OrderDetailDTO> getAllOrderDetail();

    Optional<OrderDetailDTO> getOrderDetailById(Integer id);

    void addOrderDetail(OrderDetail orderdetail);
    void updateOrderDetail(OrderDetail orderdetail);
    void deleteOrderDetailDTO(Integer id);
}
