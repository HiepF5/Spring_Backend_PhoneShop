package com.example.spring_phoneshop.dto;

import lombok.Data;

@Data
public class PurchaseInvoiceDetailDTO {
    private Integer price;
    private Integer productsId;
    private Integer purchaseInvoiceDetailId;
    private Integer purchaseInvoiceId;
    private Integer quantity;
    private Integer status;

}
