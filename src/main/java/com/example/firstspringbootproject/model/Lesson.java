package com.example.firstspringbootproject.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(columnDefinition="text")
    private String branch;
    @Column(columnDefinition="date")
    private Date date;
    @Column(columnDefinition="date")
    private Date startDate;
    @Column(columnDefinition="date")
    private Date endDate;
    @Column(columnDefinition="number")
    private int totalLessonCount;
    @Column(columnDefinition="number")
    private int currentLessonCount;

}

