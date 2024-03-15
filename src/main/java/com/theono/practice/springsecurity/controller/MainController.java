package com.theono.practice.springsecurity.controller;

import com.theono.practice.springsecurity.dto.LoginRequest;
import com.theono.practice.springsecurity.dto.LoginResult;
import com.theono.practice.springsecurity.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController {


    private final LoginService loginService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

//    @PostMapping("/login")
//    @ResponseBody
//    public ResponseEntity<LoginResult> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request){
//        log.info("POST 통신 /login 들어옴");
//        return loginService.login(loginRequest, request);
//    }

}
