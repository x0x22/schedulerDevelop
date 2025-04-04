package com.study.scheduler.responseDto;

import lombok.Getter;

import java.util.Date;

@Getter
public class TodoResponseDto {

    private final Long id;
    private final String title;
    private final String content;
    private final Date todoDate;

    public TodoResponseDto(Long id, String title, String content, Date todoDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.todoDate = todoDate;

    }
}
