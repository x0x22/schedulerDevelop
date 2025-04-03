package com.study.scheduler.requestDto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {

    private final String userid;
    private final String username;
    private final String passwords;
    private final String email;

    public SignUpRequestDto(String userid, String username, String passwords, String email) {
        this.userid = userid;
        this.username = username;
        this.passwords = passwords;
        this.email = email;
    }
}

