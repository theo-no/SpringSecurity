package com.theono.practice.springsecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginRequest {
    private String userId;
    private String password;
}
