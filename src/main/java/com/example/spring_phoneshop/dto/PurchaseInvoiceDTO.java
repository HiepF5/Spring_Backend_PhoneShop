package com.example.spring_phoneshop.dto;

import lombok.Data;

@Data
public class PurchaseInvoiceDTO {
    private Integer purchaseInvoiceId;
    private Integer supplierId;
    private Integer userId;

}
