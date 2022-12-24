package com.investment.investment.dto.mapper;

import java.math.BigDecimal;

public interface CategoryMapper {

    Long getProductId();
    String getProductName();
    String getProductCode();
    String getProductDesc();
    BigDecimal getMinimumBuy();
    Long getCategoryId();
    String getCategoryName();
}
