package com.investment.investment.repository;

import com.investment.investment.dto.mapper.TransactionMapper;
import com.investment.investment.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    @Query(value = "SELECT \n" +
            "te.transaction_id as transactionId,\n" +
            "te.user_id as userId,\n" +
            "te.holding_id as holdingId,\n" +
            "u.user_name as username,\n" +
            "te.product_id as productId,\n" +
            "p.product_name as productName,\n" +
            "p.product_code as productCode,\n" +
            "p.minimum_buy_amount as minimumBuy,\n" +
            "te.amount as amount,\n" +
            "p.product_description as productDescription,\n" +
            "p.category_entity_category_id as categoryId,\n" +
            "c.category_name as categoryName\n" +
            "FROM transaction_entity te\n" +
            "JOIN users u ON u.user_id = te.user_id\n" +
            "JOIN products p ON p.product_id = te.product_id\n" +
            "left JOIN categorys c ON c.category_id = p.category_entity_category_id \n" +
            "WHERE te.user_id  = :userId",nativeQuery = true)
    List<TransactionMapper> findTransactionByUserIdNative(@Param("userId") long userId);

  @Query(value = "select \n" +
          "te.transaction_id as transactionId,\n" +
          "te.user_id as userId,\n" +
          "u.user_name as username,\n" +
          "te.holding_id as holdingId,\n" +
          "te.product_id as productId,\n" +
          "te.transaction_type as transactionType,\n" +
          "p.product_name as productName,\n" +
          "p.product_code as productCode,\n" +
          "p.minimum_buy_amount as minimumBuy,\n" +
          "te.amount as amount,\n" +
          "p.product_description as productDescription,\n" +
          "te.starting_investment as startingInvestment\n" +
          "FROM transaction_entity te\n" +
          "JOIN users u ON u.user_id = te.user_id\n" +
          "JOIN products p ON p.product_id = te.product_id\n" +
          "left JOIN categorys c ON c.category_id = p.category_entity_category_id",nativeQuery = true)
    List<TransactionMapper> findAllTransaction();
}
