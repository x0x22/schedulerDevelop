package com.study.scheduler.requestDto;

import lombok.Getter;

import java.util.Date;

@Getter
public class CreateTodoRequestDto {

    private final String username;
    private final String title;
    private final String content;
    private final Date todoDate;



    public CreateTodoRequestDto(String username,String title, String content, Date todoDate) {
        this.username = username;
        this.title = title;
        this.content = content;
        this.todoDate = todoDate;
    }
}
