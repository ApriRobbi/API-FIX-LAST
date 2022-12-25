package com.investment.investment.service.impl;

import com.investment.investment.dto.ApiResponse;
import com.investment.investment.dto.LoginDto;
import com.investment.investment.dto.RegisterDto;
import com.investment.investment.entity.UserEntity;
import com.investment.investment.exception.BadRequestException;
import com.investment.investment.repository.UserRepository;
import com.investment.investment.service.LoginRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Service
public class LoginRegisterServiceImpl implements LoginRegisterService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ApiResponse register(RegisterDto registerDto) {
        ApiResponse apiResponse = new ApiResponse();

        UserEntity userEntity = new UserEntity();

        if (userRepository.existsByEmail(registerDto.getEmail())) {
            throw new BadRequestException("Email " + registerDto.getEmail() + " Sudah Terdaftar");
        }

        if (!StringUtils.hasText(registerDto.getFullName())){
            throw new BadRequestException("Full Name Harus Diisi");
        }
        if (!StringUtils.hasText(registerDto.getEmail())){
            throw new BadRequestException("Email Harus Diisi");
        }
        if (!StringUtils.hasText(registerDto.getPassword())){
            throw new BadRequestException("Password Harus Diisi");
        }
        if (registerDto.getPassword().length() < 8){
            throw new BadRequestException("Minimal password adalah 8 characters");
        }
        if (!StringUtils.hasText(registerDto.getPhoneNumber())){
            throw new BadRequestException("Phone Number Harus Diisi");
        }
        userEntity.setFullName(registerDto.getFullName());
        userEntity.setEmail(registerDto.getEmail());
        userEntity.setPassword(registerDto.getPassword());
        userEntity.setPhoneNumber(registerDto.getPhoneNumber());

        userEntity = userRepository.save(userEntity);
        apiResponse.setData(userEntity);

        return apiResponse;
    }

    @Override
    public ApiResponse login(LoginDto loginDto) {
        ApiResponse apiResponse = new ApiResponse();

        UserEntity userEntity = userRepository.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());

        Map<String, Object> data = new HashMap<>();
        data.put("user", userEntity);

        UserEntity user = userRepository.findByEmail(loginDto.getEmail());

        if (Objects.isNull(user)) {
            apiResponse.setData("Email Belum Terdaftar");
            apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        } else if (!user.getPassword().equalsIgnoreCase(loginDto.getPassword())) {
            apiResponse.setData("Password Salah");
            apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        } else {
            apiResponse.setData(data);
        }
        return apiResponse;
    }
}
