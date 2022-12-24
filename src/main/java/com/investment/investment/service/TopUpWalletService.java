package com.investment.investment.service;

import com.investment.investment.dto.TopUpWalletDto;

public interface TopUpWalletService {

    String topUpWallet(Long userId, TopUpWalletDto topUpWalletDto);
}
