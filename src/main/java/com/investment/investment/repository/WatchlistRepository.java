package com.investment.investment.repository;

import com.investment.investment.dto.mapper.WatchlistMapper;
import com.investment.investment.entity.WatchlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WatchlistRepository extends JpaRepository<WatchlistEntity, Long> {
    @Query(value = "SELECT " +
            "wl.watchlist_id as watchlistId,\n" +
            "wl.user_entity_user_id as userId,\n" +
            "wl.product_entity_product_id as productId,\n" +
            "u.user_name as username,\n" +
            "p.product_name as productName,\n" +
            "p.product_code as productCode,\n" +
            "p.product_description as productDescription,\n" +
            "p.minimum_buy_amount as minimumBuyAmount,\n" +
            "p.category_entity_category_id as categoryId,\n" +
            "c.category_name as category\n" +
            "\n" +
            "FROM watchlist_entity wl\n" +
            "JOIN users u ON u.user_id = wl.user_entity_user_id\n" +
            "JOIN products p ON p.product_id = wl.product_entity_product_id\n" +
            "LEFT JOIN categorys c ON c.category_id = p.category_entity_category_id\n" +
            "\n" +
            "WHERE wl.user_entity_user_id = :userId",nativeQuery = true)
    List<WatchlistMapper> findWatchlistByUserIdNative(@Param("userId")Long userId);

    @Query( value = "SELECT\n" +
            "wl.watchlist_id as watchlistId,\n" +
            "wl.user_entity_user_id as userId,\n" +
            "wl.product_entity_product_id as productId,\n" +
            "u.user_name as username,\n" +
            "p.product_name as productName,\n" +
            "p.product_code as productCode,\n" +
            "p.product_description as productDescription,\n" +
            "p.minimum_buy_amount as minimumBuyAmount,\n" +
            "p.category_entity_category_id as categoryId,\n" +
            "c.category_name as category\n" +
            "FROM watchlist_entity wl\n" +
            "JOIN users u ON u.user_id = wl.user_entity_user_id\n" +
            "JOIN products p ON p.product_id = wl.product_entity_product_id\n" +
            "JOIN categorys c ON c.category_id = p.category_entity_category_id", nativeQuery = true)
    List<WatchlistMapper> findWatchlists();


}
