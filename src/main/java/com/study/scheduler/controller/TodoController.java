package com.study.scheduler.controller;

import com.study.scheduler.requestDto.CreateTodoRequestDto;
import com.study.scheduler.responseDto.TodoResponseDto;
import com.study.scheduler.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
@RequestMapping("/schedulers")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @PostMapping("/username")
    public ResponseEntity<TodoResponseDto> saveTodo(@RequestBody CreateTodoRequestDto requestDto){

        TodoResponseDto todoResponseDto = todoService.saveTodo(
                requestDto.getUsername(),
                requestDto.getTitle(),
                requestDto.getContent(),
                (Date) requestDto.getTodoDate());

        return new ResponseEntity<>(todoResponseDto,HttpStatus.CREATED);
    }
}
