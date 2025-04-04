package com.study.scheduler.service;

import com.study.scheduler.entity.User;
import com.study.scheduler.repository.UserRepository;
import com.study.scheduler.requestDto.SignUpRequestDto;
import com.study.scheduler.responseDto.SignUpResponseDto;
import com.study.scheduler.responseDto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.w3c.dom.html.HTMLTableCaptionElement;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public SignUpResponseDto signUp(String userid, String username, String passwords, String email) {

        User user = new User(userid,username,passwords,email);

        User saveUser = userRepository.save(user);

        return new SignUpResponseDto(saveUser.getUserid(),saveUser.getUsername());
    }

    public UserResponseDto findById(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Does not exist id = " + id);
        }

        User findUser = optionalUser.get();

        return new UserResponseDto(findUser.getUserid(), findUser.getUsername(), findUser.getEmail());

    }
}
