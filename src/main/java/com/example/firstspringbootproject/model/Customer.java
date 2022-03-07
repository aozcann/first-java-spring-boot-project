package com.example.firstspringbootproject.model;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(columnDefinition="text")
    private String name;
    @Column(columnDefinition="text")
    private String surname;
    @Column(columnDefinition="text")
    private String email;
    @Column(columnDefinition="number")
    private String phoneNumber;
}
