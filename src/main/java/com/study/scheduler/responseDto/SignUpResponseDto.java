package com.study.scheduler.responseDto;

import lombok.Getter;

@Getter
public class SignUpResponseDto {

    private final String userid;
    private final String username;

    public SignUpResponseDto(String userid, String username) {

        this.userid = userid;
        this.username = username;
    }
}
