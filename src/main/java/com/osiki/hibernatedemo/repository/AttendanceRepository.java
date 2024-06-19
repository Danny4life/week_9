package com.osiki.hibernatedemo.repository;

import com.osiki.hibernatedemo.entites.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
