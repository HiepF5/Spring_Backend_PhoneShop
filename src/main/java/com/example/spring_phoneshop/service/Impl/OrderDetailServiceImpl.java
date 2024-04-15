package com.example.spring_phoneshop.service.Impl;

import com.example.spring_backend_ecommerce.entity.OrderDetail;
import com.example.spring_backend_ecommerce.exception.NotFoundException;
import com.example.spring_backend_ecommerce.model.dto.OrderDetailDTO;
import com.example.spring_backend_ecommerce.model.mapper.OrderDetailMapper;
import com.example.spring_backend_ecommerce.repository.OrderdetailRepository;
import com.example.spring_backend_ecommerce.service.OrderDetailService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    private final OrderdetailRepository orderdetailRepository;
    private final OrderDetailMapper orderdetailMapper;
    public OrderDetailServiceImpl(OrderdetailRepository orderdetailRepository, OrderDetailMapper orderdetailMapper) {
        this.orderdetailRepository = orderdetailRepository;
        this.orderdetailMapper = orderdetailMapper;
    }

    @Override
    public List<OrderDetailDTO> getAllOrderDetail() {
        List<OrderDetail> orderDetailList = orderdetailRepository.findAll();

        List<OrderDetailDTO> orderDetailDTOList = orderDetailList.stream().map(element -> orderdetailMapper.toorderdetailDTO(element)).collect(Collectors.toList());

        return orderDetailDTOList;
    }

    @Override
    public Optional<OrderDetailDTO> getOrderDetailById(Integer id) {
        OrderDetail orderdetail = orderdetailRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy Orderdetail với ID: " + id));

        OrderDetailDTO orderdetailDTO = orderdetailMapper.toorderdetailDTO(orderdetail);
        return Optional.of(orderdetailDTO);
    }

    @Override
    public void addOrderDetail(OrderDetail orderdetail) {
        orderdetailRepository.save(orderdetail);
    }

    @Override
    public void updateOrderDetail(OrderDetail orderdetail) {
        orderdetailRepository.save(orderdetail);
    }

    @Override
    public void deleteOrderDetailDTO(Integer id) {
        orderdetailRepository.deleteById(id);
    }
}
