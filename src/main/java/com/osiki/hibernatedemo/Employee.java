package com.osiki.hibernatedemo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id // marks the field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // this specifies a strategy for generating primary key values for entities
    // the generation type identity is just saying the database should manage the generating of primary key automatically
    private Long id;

    private String firstName;

    private String lastName;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
