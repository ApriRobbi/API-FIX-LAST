package com.investment.investment.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_code")
    private String productCode;
    @Column(name = "product_description")
    @Size(max = 4000)
    private String productDescription;
    @JoinColumn
    @ManyToOne
    private CategoryEntity categoryEntity;
    @Column(name = "minimum_buy_amount")
    private BigDecimal minimumBuyAmount;

    public ProductEntity(String productName, String productCode, String productDescription, BigDecimal minimumBuyAmount, CategoryEntity categoryEntity) {
        this.productName = productName;
        this.productCode = productCode;
        this.productDescription = productDescription;
        this.minimumBuyAmount = minimumBuyAmount;
        this.categoryEntity = categoryEntity;
    }

    public ProductEntity() {
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public BigDecimal getMinimumBuyAmount() {
        return minimumBuyAmount;
    }

    public void setMinimumBuyAmount(BigDecimal minimumBuyAmount) {
        this.minimumBuyAmount = minimumBuyAmount;
    }
}
