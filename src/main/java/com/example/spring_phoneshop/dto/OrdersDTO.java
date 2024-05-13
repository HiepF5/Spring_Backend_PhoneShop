package com.example.spring_phoneshop.dto;

import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class OrdersDTO {
    private Date date;
    private Integer ordersId;
    private Integer status;
    private Integer userId;
    private String address;
    private String phoneNumber;
    private String username;
    private Integer total;
    private List<OrderDetailDTO> orderDetails;

}
