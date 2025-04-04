package com.study.scheduler.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "users")
public class User extends BaseEntity{

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

    public User(){
    }

    public User(String userid, String username, String passwords, String email){
        this.userid = userid;
        this.username = username;
        this.passwords = passwords;
        this.email = email;
    }

    public void updatePassword(String passwords){
        this.passwords = passwords;
    }

}
