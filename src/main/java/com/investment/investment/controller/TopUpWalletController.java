package com.investment.investment.controller;

import com.investment.investment.dto.TopUpWalletDto;
import com.investment.investment.service.TopUpWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TopUpWalletController {

    @Autowired
    TopUpWalletService topUpWalletService;

    @PostMapping("/topup/{userId}")
    public String topUp(@PathVariable("userId") Long userId, @RequestBody TopUpWalletDto topUpWalletDto){
        return topUpWalletService.topUpWallet(userId, topUpWalletDto);
    }
}
