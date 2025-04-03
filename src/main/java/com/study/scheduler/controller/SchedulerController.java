package com.study.scheduler.controller;

import com.study.scheduler.requestDto.TodoRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SchedulerController {

    //일정 등록
    @PostMapping("/api/schedulers")
    public ResponseEntity<Void> saveTodo(@RequestBody TodoRequestDto RequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //일정 조회

//    @GetMapping("/api/schedulers/{id}")
//    public ResponseEntity<Void> findAll(){
//    }
}
