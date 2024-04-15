package com.example.spring_phoneshop.service;

import com.example.spring_backend_ecommerce.entity.Orders;
import com.example.spring_backend_ecommerce.model.dto.OrdersDTO;

import java.util.List;
import java.util.Optional;

public interface OrdersService {
    List<OrdersDTO> getAllOrders();

    Optional<OrdersDTO> getOrdersById(Integer id);

    void addOrders(Orders orders);

    void updateOrders(Orders orders);

    void deleteOrders(Integer id);
}
