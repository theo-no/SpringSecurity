package com.theono.practice.springsecurity.repository;

import com.theono.practice.springsecurity.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    public boolean findUserByIdAndPw(LoginRequest loginRequest){
        return true;
    }
}
