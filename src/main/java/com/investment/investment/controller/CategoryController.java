package com.investment.investment.controller;

import com.investment.investment.dto.mapper.CategoryMapper;
import com.investment.investment.entity.CategoryEntity;
import com.investment.investment.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public List<CategoryEntity> findAll(){
        return categoryService.findAll();
    }

//    @GetMapping("/category/{categoryId}")
//    public CategoryEntity findById(@PathVariable Long categoryId){
//        return categoryService.findById(categoryId);
//    }

    @PostMapping("/category")
    public CategoryEntity create(@RequestBody CategoryEntity categoryEntity){
        return categoryService.create(categoryEntity);
    }

    @GetMapping("/category/{categoryId}")
    public List<CategoryMapper> findByCategoryId(@PathVariable("categoryId") Long categoryId){
       return categoryService.findAllByCategoryId(categoryId);
    }

    @DeleteMapping("/category/{categoryId}")
    String deleteUser(@PathVariable Long categoryId){
        return categoryService.deleteCategory(categoryId);
    }
}
