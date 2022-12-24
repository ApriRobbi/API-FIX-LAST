package com.investment.investment.service;

import com.investment.investment.dto.mapper.TransactionMapper;
import com.investment.investment.dto.mapper.WatchlistMapper;
import com.investment.investment.entity.HoldingEntity;
import com.investment.investment.entity.TransactionEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TransactionService {

    TransactionEntity createBeli(TransactionEntity transactionEntity);

    String confirmPembelian(Long transactionId);

    List<TransactionMapper> getListTransactionByUserId(Long userId);

    List<TransactionMapper> findAllTransaction();

    String delete(Long transactionId);

    String confirmJual(Long transactionId);
}
