package com.example.userApp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    @ManyToOne
    private Parent parent;
}
