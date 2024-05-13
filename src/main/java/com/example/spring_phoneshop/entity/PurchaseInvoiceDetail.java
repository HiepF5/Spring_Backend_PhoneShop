package com.example.spring_phoneshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseInvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchaseInvoiceDetailId", nullable = false, unique = true)
    private Integer purchaseInvoiceDetailId;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @Column(name = "status", nullable = false)
    private Integer status;
    @Column(name = "price", nullable = false)
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "products_id", referencedColumnName ="productsId")
    private Products products;

    @ManyToOne
    @JoinColumn(name = "purchaseInvoice_id", referencedColumnName ="purchaseInvoiceId")
    private PurchaseInvoice purchaseInvoice;
}
