package com.investment.investment.controller;

import com.investment.investment.dto.mapper.TransactionMapper;
import com.investment.investment.entity.HoldingEntity;
import com.investment.investment.entity.TransactionEntity;
import com.investment.investment.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transaction")
    public TransactionEntity create(@RequestBody TransactionEntity transaction){
        return transactionService.createBeli(transaction);
    }

    @GetMapping("/transaction/{userId}")
    public List<TransactionMapper> findByUserId(@PathVariable ("userId") Long userId){
        return transactionService.getListTransactionByUserId(userId);
    }

    @GetMapping("/transaction")
    public List<TransactionMapper> findAll(){
        return transactionService.findAllTransaction();
    }

    @DeleteMapping("/transaction/{transactionId}")
    String delete(@PathVariable("transactionId") Long transactionId){
        return transactionService.delete(transactionId);
    }

    @PatchMapping("/transaction/{transactionId}/konfirmasi")
    public String konfirmasi(@PathVariable("transactionId") Long transactionId){
        return transactionService.confirmPembelian(transactionId);
    }

    @PostMapping("/transaction/{transactionId}/jual")
    String jual(@PathVariable("transactionId") Long transactionId){
        return transactionService.confirmJual(transactionId);
    }

}
