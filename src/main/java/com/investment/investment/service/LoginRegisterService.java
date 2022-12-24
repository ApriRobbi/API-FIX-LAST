package com.investment.investment.service;

import com.investment.investment.dto.ApiResponse;
import com.investment.investment.dto.LoginDto;
import com.investment.investment.dto.RegisterDto;

public interface LoginRegisterService {

    ApiResponse register(RegisterDto registerDto);

    ApiResponse login(LoginDto loginDto);
}
