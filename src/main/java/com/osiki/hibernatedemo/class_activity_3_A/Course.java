package com.osiki.hibernatedemo.class_activity_3_A;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "course_tbl")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;
}
