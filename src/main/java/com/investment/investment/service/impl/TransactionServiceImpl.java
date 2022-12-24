package com.investment.investment.service.impl;

import com.investment.investment.dto.mapper.HoldingMapper;
import com.investment.investment.dto.mapper.TransactionMapper;
import com.investment.investment.entity.HoldingEntity;
import com.investment.investment.entity.ProductEntity;
import com.investment.investment.entity.TransactionEntity;
import com.investment.investment.entity.UserEntity;
import com.investment.investment.exception.BadRequestException;
import com.investment.investment.repository.HoldingRepository;
import com.investment.investment.repository.ProductRepository;
import com.investment.investment.repository.TransactionRepository;
import com.investment.investment.repository.UserRepository;
import com.investment.investment.service.HoldingService;
import com.investment.investment.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    HoldingService holdingService;

    @Autowired
    HoldingRepository holdingRepository;

    @Override
    public TransactionEntity createBeli(TransactionEntity transactionEntity) {

        ProductEntity productEntity = productRepository.findById(transactionEntity.getProductId())
                .orElseThrow(() -> new BadRequestException("Produk dengan Id " + transactionEntity.getProductId() +
                        "Tidak Ditemukan"));

        UserEntity userEntity = userRepository.findById(transactionEntity.getUserId())
                .orElseThrow(() -> new BadRequestException("User dengan Id " + transactionEntity.getUserId() + ", Tidak Ditemukan."));

        Integer minimum = productEntity.getMinimumBuyAmount().intValueExact();
        Integer amount = transactionEntity.getAmount().intValueExact();

        if (minimum >= amount){
            throw new BadRequestException("Minimum pembelian harus lebih besar dari harga produk.");
        }
        Integer saldo = userEntity.getWallet().intValueExact();
        if (saldo <= amount){
            throw new BadRequestException("Jumlah uang anda tidak mencukupi untuk pembelian ini, silahkan lakukan topup.");
        }

        transactionEntity.setDate(new Date());
        transactionEntity.setUserId(userEntity.getUserId());
        transactionEntity.setProductId(productEntity.getProductId());
        transactionEntity.setStatus(false);
        transactionEntity.setTransactionType("BUY");

        return transactionRepository.save(transactionEntity);
    }

    public String confirmPembelian(Long transactionId){

        TransactionEntity transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new BadRequestException("transaction dengan id ini gaada"));

        UserEntity user = userRepository.findById(transaction.getUserId()).orElseThrow(() ->
                new BadRequestException("Id tidak ditemukan"));

        HoldingEntity holdingEntity = new HoldingEntity();
        holdingEntity.setProductId(transaction.getProductId());
        holdingEntity.setUserId(transaction.getUserId());
        holdingEntity.setStartingInvestment(transaction.getAmount());
        holdingEntity.setStatus(false);

        // dummy data untuk keuntungan
        holdingEntity.setCurrentInvestment(transaction.getAmount()
                .add(transaction.getAmount().multiply(new BigDecimal("20").
                        divide(new BigDecimal(100).setScale(2, RoundingMode.FLOOR)))));
        holdingService.create(holdingEntity);
        transactionRepository.deleteById(transactionId);

        user.setWallet(user.getWallet().subtract(transaction.getAmount()));
        userRepository.save(user);
        return "Selamat, transaksi dengan ID " + transactionId + " Sudah terkonfirmasi dan sudah masuk ke tabel holding.";
    }

    @Override
    public List<TransactionMapper> getListTransactionByUserId(Long userId) {
        return transactionRepository.findTransactionByUserIdNative(userId);
    }

    @Override
    public List<TransactionMapper> findAllTransaction() {
        return transactionRepository.findAllTransaction();
    }

    @Override
    public String delete(Long transactionId) {
        if (transactionRepository.existsById(transactionId)){
            transactionRepository.deleteById(transactionId);
            return "Transaction dengan Id" + transactionId + " SUKSES DIHAPUS";
        } else {
            return "Transaction dengan Id" + transactionId + " Tidak Ada";
        }
    }

    @Override
    public String confirmJual(Long transactionId) {
        TransactionEntity transactionEntity = transactionRepository.findById(transactionId).orElseThrow(
                () -> new BadRequestException("Transaction Id Tidak Ada"));

        UserEntity userEntity = userRepository.findById(transactionEntity.getUserId())
                        .orElseThrow(() -> new BadRequestException("user tidak ada"));

        HoldingEntity holding = holdingRepository.findById(transactionEntity.getHoldingId()).orElseThrow(() -> new BadRequestException("Id Holding Gaada"));
        userEntity.setWallet(userEntity.getWallet().add(transactionEntity.getAmount()));

        userRepository.save(userEntity);
        transactionRepository.deleteById(transactionId);
        holdingRepository.deleteById(holding.getId());
        return "Silahkan cek wallet anda";
    }


}
