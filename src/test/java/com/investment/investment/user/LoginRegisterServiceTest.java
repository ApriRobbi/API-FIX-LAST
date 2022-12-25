package com.investment.investment.user;

import com.investment.investment.dto.ApiResponse;
import com.investment.investment.dto.RegisterDto;
import com.investment.investment.exception.BadRequestException;
import com.investment.investment.service.LoginRegisterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class LoginRegisterServiceTest {

    @Autowired
    LoginRegisterService loginRegisterService;

    @Test
    void registerSuccess(){
        RegisterDto registerDto = new RegisterDto();
        registerDto.setFullName("test");
        registerDto.setEmail("test@gmail.com");
        registerDto.setPassword("testteset");
        registerDto.setPhoneNumber("999999999");

        ApiResponse user = loginRegisterService.register(registerDto);
        assertNotNull(user);
    }

    @Test
    void registerFailIfEmailHasbeen(){

        RegisterDto registerDto = new RegisterDto();
        registerDto.setFullName("test");
        registerDto.setEmail("test@gmail.com");
        registerDto.setPassword("testteset");
        registerDto.setPhoneNumber("99999");


        Exception exception = Assertions.assertThrows(BadRequestException.class, () ->{
            loginRegisterService.register(registerDto);
        });

        String expectedMessage = "Email " + registerDto.getEmail() + " Sudah Terdaftar";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void registerFaillPasswordUnderEights(){
        RegisterDto registerDto = new RegisterDto();
        registerDto.setFullName("test");
        registerDto.setEmail("test1@gmail.com");
        registerDto.setPhoneNumber("999999999");
        registerDto.setPassword("test");

        Exception exception = Assertions.assertThrows(BadRequestException.class, () ->{
            loginRegisterService.register(registerDto);
        });

        String expectedMessage = "Minimal password adalah 8 characters";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
}