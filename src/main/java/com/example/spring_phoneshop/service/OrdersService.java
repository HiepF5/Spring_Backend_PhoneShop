package com.example.spring_phoneshop.service;

import com.example.spring_phoneshop.dto.CategoryDTO;
import com.example.spring_phoneshop.dto.CheckoutOrder;
import com.example.spring_phoneshop.dto.Top5UserOrder;
import com.example.spring_phoneshop.entity.Orders;
import com.example.spring_phoneshop.dto.OrdersDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface OrdersService {
    List<OrdersDTO> getAllOrders();
    OrdersDTO getOrdersById(Integer id);
    OrdersDTO addOrders(OrdersDTO ordersDTO);
    OrdersDTO updateOrders(Integer ordersId, OrdersDTO updateOrders);
    void deleteOrders(Integer ordersId);
    void checkout(List<CheckoutOrder> checkoutOrder, Integer userId);
    List<Orders> findOrdersByMonth(Integer month);
    int countAllOrders();
    int getTotalOrderAmount();
    int getMonthWithMostOrders();
//    List<Orders> findOrdersByUserId(Integer userId);
}
