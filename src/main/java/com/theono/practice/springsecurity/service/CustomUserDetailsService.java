package com.theono.practice.springsecurity.service;

import com.theono.practice.springsecurity.dto.CustomUserDetails;
import com.theono.practice.springsecurity.entity.UserEntity;
import com.theono.practice.springsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username은 : "+username);
        UserEntity userEntity = userRepository.findByUsername(username);
        System.out.println(userEntity);
        if(userEntity != null) {

            return new CustomUserDetails(userEntity);
        }
        return null;
    }
}
