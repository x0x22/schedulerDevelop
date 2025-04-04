package com.study.scheduler.controller;

import com.study.scheduler.requestDto.SignUpRequestDto;
import com.study.scheduler.requestDto.UpdatePasswordRequestDto;
import com.study.scheduler.responseDto.SignUpResponseDto;
import com.study.scheduler.responseDto.UserResponseDto;
import com.study.scheduler.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
//생성자 주입
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto signUpRequestDto){

        SignUpResponseDto signUpResponseDto =
                userService.signUp(signUpRequestDto.getUserid(),
                        signUpRequestDto.getUsername(),
                        signUpRequestDto.getPasswords(),
                        signUpRequestDto.getEmail()
                );

        return new ResponseEntity<>(signUpResponseDto,HttpStatus.CREATED);
    }

    @GetMapping("/{userid}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable String userid){
        UserResponseDto userResponseDto = userService.findById(userid);

        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
    }

    @PatchMapping("/{userid}")
    public ResponseEntity<Void> updatePassword(
            @PathVariable String userid,
            @RequestBody UpdatePasswordRequestDto requestDto
            ){

        userService.updatePassword(userid, requestDto.getOldPassword(),requestDto.getNewPassword());

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
