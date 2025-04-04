package com.study.scheduler.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Getter
@Entity
@Table(name = "schedules")
public class Todo extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String content;

    private Date todoDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Todo(){
    }

    public Todo(String title,String content,Date todoDate){
        this.title = title;
        this.content = content;
        this.todoDate = todoDate;
    }

    public void setUser(User user){
        this.user = user;
    }
}
