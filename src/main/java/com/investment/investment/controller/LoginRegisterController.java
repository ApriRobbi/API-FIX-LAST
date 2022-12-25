package com.investment.investment.controller;

import com.investment.investment.dto.ApiResponse;
import com.investment.investment.dto.LoginDto;
import com.investment.investment.dto.RegisterDto;
import com.investment.investment.service.LoginRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class LoginRegisterController {

    @Autowired
    LoginRegisterService loginRegisterService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody RegisterDto registerDto){
        ApiResponse apiResponse = loginRegisterService.register(registerDto);

        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginDto loginDto){
        ApiResponse apiResponse = loginRegisterService.login(loginDto);

        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }
}
