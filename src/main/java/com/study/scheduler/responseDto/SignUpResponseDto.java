package com.study.scheduler.responseDto;

import lombok.Getter;

@Getter
public class SignUpResponseDto {

    private final Long id;
    private final String userid;
    private final String username;

    public SignUpResponseDto(Long id, String userid, String username) {
        this.id = id;
        this.userid = userid;
        this.username = username;
    }
}
