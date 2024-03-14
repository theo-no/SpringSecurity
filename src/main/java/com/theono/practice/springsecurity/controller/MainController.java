package com.theono.practice.springsecurity.controller;

import com.theono.practice.springsecurity.dto.LoginRequest;
import com.theono.practice.springsecurity.dto.LoginResult;
import com.theono.practice.springsecurity.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MainController {


    private final LoginService loginService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<LoginResult> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request){
        return loginService.login(loginRequest, request);
    }

}
