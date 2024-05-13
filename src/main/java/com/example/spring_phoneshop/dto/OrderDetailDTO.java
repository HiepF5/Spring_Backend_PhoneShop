package com.example.spring_phoneshop.dto;

import lombok.Data;

@Data
public class OrderDetailDTO {
    private Integer cartId;
    private Integer orderdetailId;
    private Integer ordersId;
    private Integer price;
    private Integer productsId;
    private Integer quantity;
//    private Integer status;
}
