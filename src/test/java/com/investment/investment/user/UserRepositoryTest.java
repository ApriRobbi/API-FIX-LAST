package com.investment.investment.user;

import com.investment.investment.entity.UserEntity;
import com.investment.investment.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;
    @Test
    void findByEmailSuccess() {
        UserEntity userEntity = userRepository.findByEmail("meli@gmail.com");
        assertNotNull(userEntity);
    }

    @Test
    void findByEmailNotSuccess() {
        UserEntity userEntity = userRepository.findByEmail("apapun@gmail.com");
        assertNull(userEntity);
    }

    @Test
    void findByEmailAndPasswordSuccess() {
        UserEntity userEntity = userRepository.findByEmailAndPassword("meli@gmail.com", "meli");
        assertNotNull(userEntity);
    }

    @Test
    void findByEmailAndPasswordNotSuccess() {
        UserEntity userEntity = userRepository.findByEmailAndPassword("", "");
        assertNull(userEntity);
    }

    @Test
    void existsByEmail() {
        Boolean existsByEmail = userRepository.existsByEmail("meli@gmail.com");
        assertTrue(existsByEmail);
    }

   @Test
    void existsByEmailNotSuccess() {
        Boolean existsByEmail = userRepository.existsByEmail("apapun@gmail.com");
        assertTrue(!existsByEmail);
    }
}