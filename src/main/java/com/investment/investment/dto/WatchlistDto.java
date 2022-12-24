package com.investment.investment.dto;

import java.io.Serializable;

public class WatchlistDto{

    private Long userId;
    private Long productId;

    public WatchlistDto(Long userId, Long productId) {
        this.userId = userId;
        this.productId = productId;
    }

    public WatchlistDto() {
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
}
