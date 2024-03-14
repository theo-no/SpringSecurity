package com.theono.practice.springsecurity.service;

import com.theono.practice.springsecurity.dto.LoginRequest;
import com.theono.practice.springsecurity.dto.LoginResult;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    ResponseEntity<LoginResult> login(LoginRequest loginRequest, HttpServletRequest request);
}
