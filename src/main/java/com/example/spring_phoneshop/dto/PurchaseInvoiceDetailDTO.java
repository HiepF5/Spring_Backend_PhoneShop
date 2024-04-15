package com.example.spring_phoneshop.dto;

public class PurchaseInvoiceDetailDTO {
    private Integer price;
    private Integer productsId;
    private Integer purchaseInvoiceDetailId;
    private Integer purchaseInvoiceId;
    private Integer quantity;
    private Integer status;

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getProductsId() {
        return this.productsId;
    }

    public void setProductsId(Integer productsId) {
        this.productsId = productsId;
    }

    public Integer getPurchaseInvoiceDetailId() {
        return this.purchaseInvoiceDetailId;
    }

    public void setPurchaseInvoiceDetailId(Integer purchaseInvoiceDetailId) {
        this.purchaseInvoiceDetailId = purchaseInvoiceDetailId;
    }

    public Integer getPurchaseInvoiceId() {
        return this.purchaseInvoiceId;
    }

    public void setPurchaseInvoiceId(Integer purchaseInvoiceId) {
        this.purchaseInvoiceId = purchaseInvoiceId;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
