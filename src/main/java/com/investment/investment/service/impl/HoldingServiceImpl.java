package com.investment.investment.service.impl;

import com.investment.investment.dto.mapper.HoldingMapper;
import com.investment.investment.entity.HoldingEntity;
import com.investment.investment.entity.TransactionEntity;
import com.investment.investment.entity.UserEntity;
import com.investment.investment.exception.BadRequestException;
import com.investment.investment.repository.HoldingRepository;
import com.investment.investment.repository.TransactionRepository;
import com.investment.investment.repository.UserRepository;
import com.investment.investment.service.HoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class HoldingServiceImpl implements HoldingService {

    @Autowired
    HoldingRepository holdingRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public void create(HoldingEntity holdingEntity) {
        holdingRepository.save(holdingEntity);
    }

    @Override
    public List<HoldingMapper> findAllHoldingByUserId(Long userId) {
        return holdingRepository.findHoldingByUserIdNative(userId);
    }

    @Override
    public List<HoldingMapper> findAllHolding() {
        return holdingRepository.findAllHolding();
    }

    @Override
    public String delete(Long holdingId) {
        if (holdingRepository.existsById(holdingId)){
            holdingRepository.deleteById(holdingId);
            return "Holding dengan Id " + holdingId + " Telah Dihapus";
        } else {
            return "Holding dengan Id " + holdingId + " Tidak Ditemukan";
        }
    }

    @Override
    public String createJual(Long holdingId) {

        HoldingEntity holdingEntity = holdingRepository.findById(holdingId)
                .orElseThrow(() -> new BadRequestException("Holding dengan Id " + holdingId + " Tidak Ditemukan dalam database"));

        if (holdingEntity.getStatus() == false){
            holdingEntity.setStatus(true);
            TransactionEntity transactionEntity = new TransactionEntity();
            transactionEntity.setProductId(holdingEntity.getProductId());
            transactionEntity.setUserId(holdingEntity.getUserId());
            transactionEntity.setStatus(false);
            transactionEntity.setDate(new Date());
            transactionEntity.setAmount(holdingEntity.getCurrentInvestment());
            transactionEntity.setStartingInvestment(holdingEntity.getStartingInvestment());
            transactionEntity.setHoldingId(holdingEntity.getId());
            transactionEntity.setTransactionType("SELL");
            transactionRepository.save(transactionEntity);
        } else {
            throw new BadRequestException("Holding sudah dalam proses penjualan");
        }

        return "Produk yang anda beli sudah berhasil terkonfirm. Mohon menunggu dana masuk ke wallet anda.";
    }
}
