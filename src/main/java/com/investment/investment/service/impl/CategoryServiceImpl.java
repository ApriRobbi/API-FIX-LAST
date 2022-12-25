package com.investment.investment.service.impl;

import com.investment.investment.dto.mapper.CategoryMapper;
import com.investment.investment.entity.CategoryEntity;
import com.investment.investment.exception.BadRequestException;
import com.investment.investment.repository.CategoryRepository;
import com.investment.investment.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public CategoryEntity findById(Long categoryId){
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new BadRequestException("Category dengan Id " + categoryId + " Tidak Ditemukan"));
    }

    @Override
    public List<CategoryEntity> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryEntity create(CategoryEntity categoryEntity) {

        if (!StringUtils.hasText(categoryEntity.getCategoryName())){
            throw new BadRequestException("Category Name harus diisi");
        }
        if (categoryRepository.existsByCategoryName(categoryEntity.getCategoryName())){
            throw new BadRequestException("Category " + categoryEntity.getCategoryName() + " Sudah Terdaftar");
        }
        return categoryRepository.save(categoryEntity);
    }

    @Override
    public List<CategoryMapper> findAllByCategoryId(Long categoryId) {
        List<CategoryMapper> result = categoryRepository.findAllByCategoryId(categoryId);
        if (result.size() > 0){
            return result;
        } else {
        throw new BadRequestException("Category Id tidak ditemukan.");
        }
    }

    @Override
    public String deleteCategory(Long categoryId) {
        if (categoryRepository.existsById(categoryId)){
            categoryRepository.deleteById(categoryId);
            return "User dengan Id " + categoryId + " Telah Dihapus";
        } else {
            return "User dengan Id " + categoryId + " Tidak Ditemukan";
        }
    }



}
