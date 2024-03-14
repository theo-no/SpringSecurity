package com.theono.practice.springsecurity.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class LoginResult {
    private boolean isSuccess;
    private String errorMsg;
    private String userId;
}
