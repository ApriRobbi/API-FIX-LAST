package com.investment.investment.service;

import com.investment.investment.dto.mapper.CategoryMapper;
import com.investment.investment.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {

    CategoryEntity findById(Long categoryId);

    List<CategoryEntity> findAll();

    CategoryEntity create(CategoryEntity categoryEntity);

    String deleteCategory(Long categoryId);

    List<CategoryMapper> findAllByCategoryId(Long categoryId);
}
