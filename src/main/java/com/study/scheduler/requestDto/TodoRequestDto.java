package com.study.scheduler.requestDto;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Getter
public class TodoRequestDto {

    private String title;
    private String content;
    private Date tododate;


}
