package com.investment.investment.repository;

import com.investment.investment.dto.mapper.CategoryMapper;
import com.investment.investment.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    boolean existsByCategoryName(String categoryName);

    @Query(value = "SELECT \n" +
            "p.product_id as productId,\n" +
            "p.product_name as productName,\n" +
            "p.product_code as productCode,\n" +
            "p.product_description as productDesc,\n" +
            "p.minimum_buy_amount as minimumBuy,\n" +
            "c.category_id as categoryId, \n" +
            "c.category_name as categoryName\n" +
            "FROM categorys c\n" +
            "JOIN products p ON p.category_entity_category_id  = c.category_id\n" +
            "where c.category_id = :categoryId", nativeQuery = true)
    List<CategoryMapper> findAllByCategoryId(@Param("categoryId") Long categoryId);
}
