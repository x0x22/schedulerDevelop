package com.study.scheduler.responseDto;

import lombok.Getter;

@Getter
public class UserResponseDto {

    private final String userid;
    private final String username;
    private final String email;

    public UserResponseDto(String userid, String username, String email) {
        this.userid = userid;
        this.username = username;
        this.email = email;
    }
}
