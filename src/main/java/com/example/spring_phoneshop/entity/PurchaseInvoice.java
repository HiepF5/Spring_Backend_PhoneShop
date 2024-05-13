package com.example.spring_phoneshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "purchase_invoice")
public class PurchaseInvoice{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchaseInvoiceId", nullable = false, unique = true)
    private Integer purchaseInvoiceId;

    @OneToMany(mappedBy = "purchaseInvoice")
    private Set<PurchaseInvoiceDetail> purchaseInvoiceDetails;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName ="userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName ="supplierId")
    private Supplier supplier;
}
