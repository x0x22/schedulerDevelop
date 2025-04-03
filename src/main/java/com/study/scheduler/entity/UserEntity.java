package com.study.scheduler.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String userid;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String passwords;

    @Column(nullable = false)
    private String email;

}
