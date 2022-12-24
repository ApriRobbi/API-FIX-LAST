package com.investment.investment.dto.mapper;

import java.math.BigDecimal;

public interface HoldingMapper {

    Long getHoldingId();
    Long getUserId();
    String getUsername();
    Long getProductId();
    String getProductName();
    String getProductCode();
    BigDecimal getMinimumBuy();
    String getProductDesc();
    Long getCategoryId();
    String getCategoryName();
    BigDecimal getCurrentInvestment();
    BigDecimal getStartingInvestment();
    String getStatus();
}
