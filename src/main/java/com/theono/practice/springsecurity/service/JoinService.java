package com.theono.practice.springsecurity.service;

import com.theono.practice.springsecurity.dto.JoinDto;
import com.theono.practice.springsecurity.entity.UserEntity;
import com.theono.practice.springsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinProcess(JoinDto joinDto){

        //동일한 이름의 회원이 있는지 확인
        if(userRepository.existsByUsername(joinDto.getUsername())){
            return;
        }

        UserEntity userEntity = new UserEntity(
                joinDto.getUsername(),
                bCryptPasswordEncoder.encode(joinDto.getPassword()),
                "ROLE_ADMIN"
        );

        userRepository.save(userEntity);
    }
}
