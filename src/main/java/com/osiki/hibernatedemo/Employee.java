package com.osiki.hibernatedemo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    private Long id;

    private String firstName;

    private String lastName;
}
