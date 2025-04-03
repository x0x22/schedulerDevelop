package com.study.scheduler.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "schedules")
public class TodoEntity extends BaseEntity{

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
    private UserEntity userEntity;

}
