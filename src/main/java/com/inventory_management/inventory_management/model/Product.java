package com.inventory_management.inventory_management.model;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name="Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "product_name", nullable = false, length = 30)
    private String productName;

    @Column(name="description" , nullable = false, length = 100)
    private String description;

    @Column(name = "Stock", nullable = false)
    private long stock;

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public long getStock() {
        return stock;
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public LocalDate getDate() {
        return date;
    }

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @Temporal(TemporalType.DATE)
    private LocalDate date;

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", status=" + status +
                ", date=" + date +
                '}';
    }

    @PrePersist
    public void prePersist(){
        this.date= LocalDate.now();
    }
}
