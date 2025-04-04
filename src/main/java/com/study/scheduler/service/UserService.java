package com.study.scheduler.service;

import com.study.scheduler.entity.User;
import com.study.scheduler.repository.UserRepository;
import com.study.scheduler.requestDto.SignUpRequestDto;
import com.study.scheduler.responseDto.SignUpResponseDto;
import com.study.scheduler.responseDto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    public UserResponseDto findById(String userid) {

        Optional<User> optionalUser = userRepository.findByUserid(userid);

        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Does not exist id = " + userid);
        }

        User findUser = optionalUser.get();

        return new UserResponseDto(findUser.getUserid(), findUser.getUsername(), findUser.getEmail());

    }

    @Transactional
    public void updatePassword(String userid, String oldPassword, String newPassword) {

        User findUser = userRepository.findByUserIdOrElseThrow(userid);

        if (!findUser.getPasswords().equals(oldPassword)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"비밀번호가 일치하지 않습니다.");
        }

        findUser.updatePassword(newPassword);
    }
}
