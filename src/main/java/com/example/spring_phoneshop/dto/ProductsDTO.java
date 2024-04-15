package com.example.spring_phoneshop.dto;

public class ProductsDTO {
    private Integer categoryId;
    private Integer price;
    private Integer productsId;
    private Integer quantity;
    private Integer sold;
    private String brand;
    private String description;
    private String image;
    private String productsName;

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

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

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getSold() {
        return this.sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProductsName() {
        return this.productsName;
    }

    public void setProductsName(String productsName) {
        this.productsName = productsName;
    }
}
