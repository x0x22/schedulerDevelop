package com.study.scheduler.service;

import com.study.scheduler.entity.User;
import com.study.scheduler.repository.UserRepository;
import com.study.scheduler.requestDto.SignUpRequestDto;
import com.study.scheduler.responseDto.SignUpResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public SignUpResponseDto signUp(String userid, String username, String passwords, String email) {

        User user = new User(userid,username,passwords,email);

        User saveUser = userRepository.save(user);

        return new SignUpResponseDto(saveUser.getUserid(),saveUser.getUsername());
    }
}
