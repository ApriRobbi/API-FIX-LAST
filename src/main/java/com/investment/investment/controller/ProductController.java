package com.investment.investment.controller;

import com.investment.investment.entity.ProductEntity;
import com.investment.investment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ProductEntity create(@RequestBody ProductEntity productEntity){
        return productService.createProduct(productEntity);
    }

    @GetMapping("/product/{productId}")
    public ProductEntity findById(@PathVariable Long productId){
        return productService.findById(productId);
    }

    @GetMapping("/product")
    public List<ProductEntity> findAll(){
        return productService.findAll();
    }

    @PutMapping("/product/{productId}")
    public ProductEntity update(@PathVariable Long productId, @RequestBody ProductEntity productEntity){
        return productService.update(productId, productEntity);
    }

    @DeleteMapping("/product/{productId}")
    String delete(@PathVariable Long productId){
        return productService.deleteProduct(productId);
    }
}
