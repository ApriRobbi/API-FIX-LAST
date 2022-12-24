package com.investment.investment.service.impl;

import com.investment.investment.dto.TopUpWalletDto;
import com.investment.investment.entity.UserEntity;
import com.investment.investment.exception.BadRequestException;
import com.investment.investment.repository.UserRepository;
import com.investment.investment.service.TopUpWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopUpWalletServiceImpl implements TopUpWalletService {

    @Autowired
    UserRepository userRepository;
    @Override
    public String topUpWallet(Long userId, TopUpWalletDto topUpWalletDto) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestException("User dengan Id " + userId + " tidak Ditemukan"));

        if (userEntity.getWallet() != null){
            userEntity.setWallet(userEntity.getWallet().add(topUpWalletDto.getWallet()));
        } else {
            userEntity.setWallet(topUpWalletDto.getWallet());
        }

        userRepository.save(userEntity);
        return "Selamat, anda telah berhasil melakukan Top Up. Saldo Anda Sekarang adalah Rp." + userEntity.getWallet();
    }
}
