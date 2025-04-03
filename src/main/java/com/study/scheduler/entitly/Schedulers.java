package com.study.scheduler.entitly;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Schedulers {
    @Id
    private Long id;

    private String title;
    private String content;
    private Date tododate;
    private Date createdate;
    private Date changedate;

}
