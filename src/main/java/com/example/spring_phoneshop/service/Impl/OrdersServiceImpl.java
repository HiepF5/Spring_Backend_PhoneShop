package com.example.spring_phoneshop.service.Impl;

import com.example.spring_backend_ecommerce.entity.Orders;
import com.example.spring_backend_ecommerce.exception.NotFoundException;
import com.example.spring_backend_ecommerce.model.dto.OrdersDTO;
import com.example.spring_backend_ecommerce.model.mapper.OrdersMappper;
import com.example.spring_backend_ecommerce.repository.OrdersRepository;
import com.example.spring_backend_ecommerce.service.OrdersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;
    private final OrdersMappper ordersMappper;
    public OrdersServiceImpl(OrdersRepository ordersRepository, OrdersMappper ordersMappper) {
        this.ordersRepository = ordersRepository;
        this.ordersMappper = ordersMappper;
    }

    @Override
    public List<OrdersDTO> getAllOrders() {
        List<Orders> orderList = ordersRepository.findAll();

        List<OrdersDTO> ordersDTOList = orderList.stream().map(element -> ordersMappper.toordersDTO(element)).collect(Collectors.toList());

        return ordersDTOList;
    }

    @Override
    public Optional<OrdersDTO> getOrdersById(Integer id) {
        Orders orders = ordersRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy Clothes với ID: " + id));

        OrdersDTO ordersDTO = ordersMappper.toordersDTO(orders);
        return Optional.of(ordersDTO);
    }

    @Override
    public void addOrders(Orders orders) {
        ordersRepository.save(orders);
    }

    @Override
    public void updateOrders(Orders orders) {
        ordersRepository.save(orders);
    }

    @Override
    public void deleteOrders(Integer id) {
        ordersRepository.deleteById(id);

    }
}
