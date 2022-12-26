package com.investment.investment.user;

import com.investment.investment.dto.ApiResponse;
import com.investment.investment.dto.LoginDto;
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
    void registerFailIfEmailHasbeenRegistered(){

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
    void registerFailFullnameNotFilled(){
        RegisterDto registerDto = new RegisterDto();
        registerDto.setFullName("");
        registerDto.setEmail("test@gmail.com");
        registerDto.setPassword("testteset");
        registerDto.setPhoneNumber("99999");


        Exception exception = Assertions.assertThrows(BadRequestException.class, () ->{
            loginRegisterService.register(registerDto);
        });

        String expectedMessage = "Full Name Harus Diisi";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void registerFailedEmailNotFilledProperly(){
        RegisterDto registerDto = new RegisterDto();
        registerDto.setFullName("test");
        registerDto.setEmail("");
        registerDto.setPassword("testteset");
        registerDto.setPhoneNumber("99999");


        Exception exception = Assertions.assertThrows(BadRequestException.class, () ->{
            loginRegisterService.register(registerDto);
        });

        String expectedMessage = "Email Harus Diisi";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void registerFailledPasswordNotFilledProperly(){
        RegisterDto registerDto = new RegisterDto();
        registerDto.setFullName("test");
        registerDto.setEmail("test@gmail.com");
        registerDto.setPassword("");
        registerDto.setPhoneNumber("99999");


        Exception exception = Assertions.assertThrows(BadRequestException.class, () ->{
            loginRegisterService.register(registerDto);
        });

        String expectedMessage = "Password Harus Diisi";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void registerFailedPhoneNumberNotFilledProperly(){
        RegisterDto registerDto = new RegisterDto();
        registerDto.setFullName("test");
        registerDto.setEmail("test@gmail.com");
        registerDto.setPassword("testteset");
        registerDto.setPhoneNumber("");


        Exception exception = Assertions.assertThrows(BadRequestException.class, () ->{
            loginRegisterService.register(registerDto);
        });

        String expectedMessage = "Phone Number Harus Diisi";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void registerFaillPasswordUnderEightsChar(){
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

    @Test
    void loginSuccess(){
        LoginDto loginDto = new LoginDto();

        //email untuk test adalah email yang sudah terdaftar
        loginDto.setEmail("test@gmail.com");
        loginDto.setPassword("testteset");

        ApiResponse apiResponse = loginRegisterService.login(loginDto);
        assertNotNull(apiResponse);
    }

    @Test
    void loginNotSuccessWithNotRegisteredEmail(){
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("notRegisteredEmail@gmail.com");
        loginDto.setPassword("testteset");

        ApiResponse apiResponse = loginRegisterService.login(loginDto);

        Integer expectedStatus = 400;
        String expectedMessage = "Email Belum Terdaftar";

        assertEquals(apiResponse.getStatus().equals(expectedStatus), apiResponse.getData().equals(expectedMessage));
    }

    @Test
    void loginNotSuccessWithWrongPassword(){
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("test@gmail.com");
        loginDto.setPassword("wrongPassword");

        ApiResponse apiResponse = loginRegisterService.login(loginDto);

        Integer expectedStatus = 400;
        String expectedMessage = "Password Salah";

        assertEquals(apiResponse.getStatus().equals(expectedStatus), apiResponse.getData().equals(expectedMessage));
    }
}