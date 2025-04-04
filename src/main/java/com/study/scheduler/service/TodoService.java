package com.study.scheduler.service;

import com.study.scheduler.entity.Todo;
import com.study.scheduler.entity.User;
import com.study.scheduler.repository.TodoRepository;
import com.study.scheduler.repository.UserRepository;
import com.study.scheduler.responseDto.TodoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final UserRepository userRepository;
    private final TodoRepository todoRepository;

    public TodoResponseDto saveTodo(String username,String title, String content, Date todoDate){

        User user = userRepository.findByUserIdOrElseThrow(username);
        Todo todo = new Todo(title,content,todoDate);
        todo.setUser(user);

        todoRepository.save(todo);

        return null;
    }
}
