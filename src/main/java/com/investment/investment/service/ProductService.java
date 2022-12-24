package com.investment.investment.service;

import com.investment.investment.entity.ProductEntity;
import com.investment.investment.entity.UserEntity;

import java.util.List;

public interface ProductService {

    ProductEntity createProduct(ProductEntity productEntity);

    ProductEntity findById(Long productId);

    List<ProductEntity> findAll();

    ProductEntity update(Long productId, ProductEntity productEntity);

    String deleteProduct(Long productId);

}
