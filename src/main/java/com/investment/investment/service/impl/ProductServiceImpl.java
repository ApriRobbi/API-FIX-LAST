package com.investment.investment.service.impl;

import com.investment.investment.entity.CategoryEntity;
import com.investment.investment.entity.ProductEntity;
import com.investment.investment.exception.BadRequestException;
import com.investment.investment.repository.CategoryRepository;
import com.investment.investment.repository.ProductRepository;
import com.investment.investment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public ProductEntity createProduct(ProductEntity productEntity) {
        if (productRepository.existsByProductName(productEntity.getProductName())){
            throw new BadRequestException("Produk " + productEntity.getProductName() + " Sudah Terdaftar");
        }

        categoryRepository.findById(productEntity.getCategoryEntity().getCategoryId())
                .orElseThrow(() -> new BadRequestException("Kategory Tidak ada"));
        if (productEntity.getProductName() == null){
            throw new BadRequestException("Nama Produk Harus Diisi");
        }
        if (productEntity.getProductCode() == null){
            throw new BadRequestException("Produk CODE Harus Diisi");
        }
        if (productEntity.getProductDescription() == null){
            throw new BadRequestException("Produk Description Harus Diisi");
        }
        if (productEntity.getCategoryEntity().getCategoryId() == null){
            throw new BadRequestException("Category Harus Diisi");
        }
        if (productEntity.getMinimumBuyAmount() == null){
            throw new BadRequestException("Harga Harus Dimasukan");
        }
        return productRepository.save(productEntity);
    }

    @Override
    public ProductEntity findById(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new BadRequestException("Product dengan Id " + productId + " Tidak Ditemukan"));
    }

    @Override
    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    @Override
    public ProductEntity update(Long productId, ProductEntity productEntity) {

        ProductEntity original = findById(productId);
        if (productEntity.getProductName() == null){
            original.setProductName(productEntity.getProductName());
        }
        if (productEntity.getProductCode() == null){
            original.setProductCode(productEntity.getProductCode());
        }
        if (productEntity.getProductDescription() == null){
            original.setProductDescription(productEntity.getProductDescription());
        }
        if (productEntity.getMinimumBuyAmount() == null){
            original.setMinimumBuyAmount(productEntity.getMinimumBuyAmount());
        }

        return productRepository.save(original);
    }

    @Override
    public String deleteProduct(Long productId) {
        if (productRepository.existsById(productId)){
            productRepository.deleteById(productId);
            return "Product dengan Id " + productId + " Telah Dihapus";
        } else {
            return "Product dengan Id " + productId + " Tidak Ditemukan";
        }
    }
}
