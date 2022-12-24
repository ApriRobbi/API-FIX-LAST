package com.investment.investment.service;

import com.investment.investment.entity.UserEntity;

import java.math.BigDecimal;
import java.util.List;

public interface UserService {

    UserEntity createUser(UserEntity userEntity);

    UserEntity findById(Long userId);

    List<UserEntity> findAll();

    UserEntity update(Long userId, UserEntity userEntity);

    String deleteUser(Long userid);
}
