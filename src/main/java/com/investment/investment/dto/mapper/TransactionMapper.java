package com.investment.investment.dto.mapper;

import java.math.BigDecimal;

public interface TransactionMapper {

    Long getTransactionId();
    Long getUserId();
    String getUsername();
    Long getProductId();
    String getProductName();
    String getProductCode();
    String getProductDescription();
    BigDecimal getMinimumBuy();
    BigDecimal getAmount();
    BigDecimal getStartingInvestment();
    Long getHoldingId();
    String getTransactionType();

}
