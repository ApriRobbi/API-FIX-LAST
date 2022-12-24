package com.investment.investment.repository;

import com.investment.investment.dto.mapper.HoldingMapper;
import com.investment.investment.entity.HoldingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HoldingRepository extends JpaRepository<HoldingEntity, Long> {
    @Query(value = "SELECT \n" +
            "h.holding_id as holdingId,\n" +
            "h.user_id as userId,\n" +
            "u.user_name as username,\n" +
            "h.product_id as productId,\n" +
            "p.product_name as productName,\n" +
            "p.product_code as productCode,\n" +
            "p.minimum_buy_amount as minimumBuy,\n" +
            "p.product_description as productDesc,\n" +
            "p.category_entity_category_id as categoryId,\n" +
            "c.category_name as categoryName,\n" +
            "h.current_investment as currentInvestment,\n" +
            "h.starting_investment as startingInvestment,\n" +
            "h.status as status\n" +
            "FROM holding h \n" +
            "JOIN users u ON u.user_id = h.user_id \n" +
            "JOIN products p ON p.product_id = h.product_id \n" +
            "left JOIN categorys c ON c.category_id = p.category_entity_category_id\n" +
            "where h.user_id = :userId", nativeQuery = true)
    List<HoldingMapper> findHoldingByUserIdNative(@Param("userId") Long userID);

    @Query(value = "SELECT \n" +
            "h.holding_id as holdingId,\n" +
            "h.user_id as userId,\n" +
            "u.user_name as username,\n" +
            "h.product_id as productId,\n" +
            "p.product_name as productName,\n" +
            "p.product_code as productCode,\n" +
            "p.minimum_buy_amount as minimumBuy,\n" +
            "p.product_description as productDesc,\n" +
            "p.category_entity_category_id as categoryId,\n" +
            "c.category_name as categoryName,\n" +
            "h.current_investment as currentInvestment,\n" +
            "h.starting_investment as startingInvestment,\n" +
            "h.status as status\n" +
            "FROM holding h \n" +
            "JOIN users u ON u.user_id = h.user_id \n" +
            "JOIN products p ON p.product_id = h.product_id \n" +
            "left JOIN categorys c ON c.category_id = p.category_entity_category_id", nativeQuery = true)
    List<HoldingMapper> findAllHolding();
}
