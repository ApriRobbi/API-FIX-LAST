package com.investment.investment.dto.mapper;

import java.math.BigDecimal;

public interface WatchlistMapper {

    Long getWatchlistId();
    Long getUserId();
    Long getProductId();
    String getUsername();
    String getProductName();
    String getProductCode();
    String getProductDescription();
    BigDecimal getMinimumBuyAmount();
    Long getCategoryId();
    String getCategory();

}
