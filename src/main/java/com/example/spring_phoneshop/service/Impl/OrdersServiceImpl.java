package com.example.spring_phoneshop.service.Impl;

import com.example.spring_phoneshop.dto.OrdersDTO;
import com.example.spring_phoneshop.dto.CheckoutOrder;
import com.example.spring_phoneshop.dto.Top5UserOrder;
import com.example.spring_phoneshop.entity.*;
import com.example.spring_phoneshop.exception.NotFoundException;
import com.example.spring_phoneshop.mapper.OrdersMapper;
import com.example.spring_phoneshop.repository.OrderDetailRepository;
import com.example.spring_phoneshop.repository.OrdersRepository;
import com.example.spring_phoneshop.repository.ProductsRepository;
import com.example.spring_phoneshop.repository.UserRepository;
import com.example.spring_phoneshop.service.OrdersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;
    private final UserRepository userRepository;
    private final OrdersMapper ordersMapper;
    private final ProductsRepository productsRepository;
    private final OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrdersDTO> getAllOrders() {
        List<Orders> ordersList = ordersRepository.findAll();
        List<OrdersDTO> ordersDTOList = ordersList.stream().map(element -> ordersMapper.mapToOrdersDTO(element)).collect(Collectors.toList());
        return ordersDTOList;
    }

    @Override
    public OrdersDTO getOrdersById(Integer id) {
        Orders category = ordersRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy Orders với ID: " + id));
        OrdersDTO categoryDTO = ordersMapper.mapToOrdersDTO(category);
        return categoryDTO;
    }

    @Override
    public OrdersDTO addOrders(OrdersDTO categoryDTO) {
        Orders category = ordersMapper.mapToOrdersEntity(categoryDTO);
        Orders saveOrders = ordersRepository.save(category);
        return ordersMapper.mapToOrdersDTO(saveOrders);
    }

    @Override
    public OrdersDTO updateOrders(Integer ordersId, OrdersDTO updateOrders) {
        if (ordersId == null || updateOrders == null) {
            throw new IllegalArgumentException("categoryId và updateOrders không được null");
        }
        Orders existingOrders = ordersRepository.findById(ordersId)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy sản phẩm có ID: " + ordersId));
        existingOrders.setAddress(updateOrders.getAddress());
        Orders saveOrders = ordersRepository.save(existingOrders);
        return ordersMapper.mapToOrdersDTO(saveOrders);
    }

    @Override
    public void deleteOrders(Integer categoryId) {
        Orders category = ordersRepository.findById(categoryId)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy Orders có ID:" + categoryId));
        ordersRepository.deleteById(categoryId);
    }

    @Override
    public void checkout(List<CheckoutOrder> checkoutOrder, Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy User với ID: " + userId));
        Orders orders = new Orders();
        orders.setUser(user);
        orders.setPhoneNumber(user.getPhoneNumber());
        Date date = new Date();
        orders.setDate((new java.sql.Date(date.getTime())));
        orders.setAddress(user.getAddress());
        orders.setUsername(user.getUsername());
        orders.setStatus(0);
        orders.setTotal(0);
        ordersRepository.save(orders);
        Integer sum = 0;
        for (CheckoutOrder checkoutOrder1 : checkoutOrder) {
            Products products = productsRepository.findById(checkoutOrder1.getProductId()).get();
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProducts(products);
            orderDetail.setOrders(orders);
            orderDetail.setQuantity(checkoutOrder1.getQuantity());
            sum = sum + checkoutOrder1.getQuantity() * products.getPrice();
//            orderDetail.setStatus(0);
            orderDetail.setPrice(products.getPrice());
            orderDetailRepository.save(orderDetail);
            products.setQuantity(products.getQuantity() - checkoutOrder1.getQuantity());
            products.setSold(products.getSold() + checkoutOrder1.getQuantity());
            productsRepository.save(products);
        }
        orders.setTotal(sum);
        ordersRepository.save(orders);

    }

    @Override
    public List<Orders> findOrdersByMonth(Integer month) {
        return ordersRepository.findOrdersByMonth(month);
    }

//    @Override
//    public List<Orders> findOrdersByUserId(Integer userId) {
//        return ordersRepository.findByUserId(userId);
//    }
    @Override
    public int countAllOrders() {
        return ordersRepository.countAllOrders();
    }
    @Override
    public int getTotalOrderAmount() {
        return ordersRepository.getTotalOrderAmount();
    }
    @Override
    public int getMonthWithMostOrders() {
        return ordersRepository.findMonthWithMostOrders();
    }
}
