package com.investment.investment.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "holding")
public class HoldingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "holding_id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "productId")
    private Long productId;

    @Column(name = "starting_investment")
    private BigDecimal startingInvestment;

    @Column(name = "current_investment")
    private BigDecimal currentInvestment;

    @Column(name = "status")
    private boolean status;

    public HoldingEntity(Long userId, Long productId, BigDecimal startingInvestment, BigDecimal currentInvestment, boolean status) {
        this.userId = userId;
        this.productId = productId;
        this.startingInvestment = startingInvestment;
        this.currentInvestment = currentInvestment;
        this.status = status;
    }

    public HoldingEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getStartingInvestment() {
        return startingInvestment;
    }

    public void setStartingInvestment(BigDecimal startingInvestment) {
        this.startingInvestment = startingInvestment;
    }

    public BigDecimal getCurrentInvestment() {
        return currentInvestment;
    }

    public void setCurrentInvestment(BigDecimal currentInvestment) {
        this.currentInvestment = currentInvestment;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
