package com.investment.investment.entity;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class TransactionEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @NotNull(message = "gaboleh null")
    private Long userId;

    @NotNull(message = "gaboleh null")
    private Long productId;

    @Column(name = "amount")
    private BigDecimal amount;

    private Date date;

    private Long holdingId;

    private String transactionType;

    private Boolean status;

    private BigDecimal startingInvestment;

    public TransactionEntity(Long holdingId, Long userId, Long productId, BigDecimal amount, Date date, String transactionType, Boolean status, BigDecimal startingInvestment) {
        this.userId = userId;
        this.productId = productId;
        this.amount = amount;
        this.date = date;
        this.transactionType = transactionType;
        this.status = status;
        this.startingInvestment = startingInvestment;
        this.holdingId = holdingId;
    }

    public TransactionEntity() {
    }

    public Long getHoldingId() {
        return holdingId;
    }

    public void setHoldingId(Long holdingId) {
        this.holdingId = holdingId;
    }

    public BigDecimal getStartingInvestment() {
        return startingInvestment;
    }

    public void setStartingInvestment(BigDecimal startingInvestment) {
        this.startingInvestment = startingInvestment;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
