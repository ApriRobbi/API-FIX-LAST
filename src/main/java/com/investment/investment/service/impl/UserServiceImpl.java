package com.investment.investment.service.impl;

import com.investment.investment.entity.UserEntity;
import com.investment.investment.exception.BadRequestException;
import com.investment.investment.exception.NotFoundException;
import com.investment.investment.repository.UserRepository;
import com.investment.investment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserEntity createUser(UserEntity userEntity) {

        if (!StringUtils.hasText(userEntity.getFullName())){
            throw new BadRequestException("Nama Harus Diisi");
        }
        if (!StringUtils.hasText(userEntity.getEmail())){
            throw new BadRequestException("Email Harus Diisi");
        }
        if (!StringUtils.hasText(userEntity.getPassword())){
            throw new BadRequestException("Password Harus Diisi");
        }
        if (!StringUtils.hasText(userEntity.getPhoneNumber())){
            throw new BadRequestException("Nomor Telfon Harus Diisi");
        }
        if (userRepository.existsByEmail(userEntity.getEmail())){
            throw new BadRequestException("Email " + userEntity.getEmail() + " Telah Terdaftar");
        }

        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity findById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User Id Tidak ditemukan"));
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity update(Long userId, UserEntity userEntity) {
        UserEntity original = findById(userId);

        if (userEntity.getFullName() != null){
            original.setFullName(userEntity.getFullName());
        }
        if (userEntity.getEmail() != null){
            original.setEmail(userEntity.getEmail());
        }
        if (userEntity.getPassword() != null){
            original.setPassword(userEntity.getPassword());
        }
        if (userEntity.getPhoneNumber() != null){
            original.setPhoneNumber(userEntity.getPhoneNumber());
        }

        return userRepository.save(original);
    }

    @Override
    public String deleteUser(Long userid) {
        if (userRepository.existsById(userid)){
            userRepository.deleteById(userid);
            return "User dengan Id " + userid + " Telah Dihapus";
        } else {
            return "User dengan Id " + userid + " Tidak Ditemukan";
        }
    }
}
