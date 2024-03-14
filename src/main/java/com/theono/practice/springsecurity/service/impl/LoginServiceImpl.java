package com.theono.practice.springsecurity.service.impl;

import com.theono.practice.springsecurity.dto.LoginRequest;
import com.theono.practice.springsecurity.dto.LoginResult;
import com.theono.practice.springsecurity.repository.UserRepository;
import com.theono.practice.springsecurity.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<LoginResult> login(LoginRequest loginRequest, HttpServletRequest request) {

        if(!userRepository.findUserByIdAndPw(loginRequest)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(LoginResult.builder().isSuccess(false).errorMsg("id, pw 틀림").build());
        }

        return ResponseEntity.ok(LoginResult.builder().userId(loginRequest.getUserId()).build());
    }
}
