package com.osiki.hibernatedemo.repository;

import com.osiki.hibernatedemo.entites.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Boolean existsByEmail(String email);
}
