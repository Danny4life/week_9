package com.osiki.hibernatedemo.class_activity_1_and_2_A;

import com.osiki.hibernatedemo.class_activity_1_and_2_A.Employee;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "department_tbl")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;
}
