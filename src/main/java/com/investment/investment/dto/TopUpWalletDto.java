package com.investment.investment.dto;

import java.math.BigDecimal;

public class TopUpWalletDto {

    BigDecimal wallet;

    public TopUpWalletDto(BigDecimal wallet) {
        this.wallet = wallet;
    }

    public TopUpWalletDto() {
    }

    public BigDecimal getWallet() {
        return wallet;
    }

    public void setWallet(BigDecimal wallet) {
        this.wallet = wallet;
    }
}
