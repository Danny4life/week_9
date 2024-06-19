package com.osiki.hibernatedemo.entites.model;

import com.osiki.hibernatedemo.entites.enums.Designation;
import com.osiki.hibernatedemo.entites.enums.Gender;
import com.osiki.hibernatedemo.entites.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "employee_tbl")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee extends BaseClass {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Designation designation;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Attendance> attendance;
}
