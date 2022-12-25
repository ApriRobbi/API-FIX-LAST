package com.investment.investment.category;

import com.investment.investment.dto.mapper.CategoryMapper;
import com.investment.investment.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void findAllByCategoryIdSuccess() {
        List<CategoryMapper> findAll = categoryRepository.findAllByCategoryId(3L);
        assertEquals(findAll.size(), findAll.size());
    }

    @Test
    void findAllByCategoryIdNotSuccess(){
        List<CategoryMapper> findAll = categoryRepository.findAllByCategoryId(4L);
        assertEquals(0, findAll.size());
    }

    @Test
    void existsByCategoryName() {
        Boolean exists = categoryRepository.existsByCategoryName("convensional");
        assertTrue(exists);
    }

    @Test
    void existsByCategoryNameNotSuccess(){
        Boolean exists = categoryRepository.existsByCategoryName("apapun");
        assertFalse(exists);
    }
}