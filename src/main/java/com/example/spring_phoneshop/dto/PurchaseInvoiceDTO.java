package com.example.spring_phoneshop.dto;

public class PurchaseInvoiceDTO {
    private Integer purchaseInvoiceId;
    private Integer supplierId;
    private Integer userId;

    public Integer getPurchaseInvoiceId() {
        return this.purchaseInvoiceId;
    }

    public void setPurchaseInvoiceId(Integer purchaseInvoiceId) {
        this.purchaseInvoiceId = purchaseInvoiceId;
    }

    public Integer getSupplierId() {
        return this.supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
