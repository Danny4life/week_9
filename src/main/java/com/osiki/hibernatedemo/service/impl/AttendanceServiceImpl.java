package com.osiki.hibernatedemo.service.impl;

import com.osiki.hibernatedemo.entites.model.Attendance;
import com.osiki.hibernatedemo.entites.model.Employee;
import com.osiki.hibernatedemo.exception.EmployeeDoesNotExistsException;
import com.osiki.hibernatedemo.payload.request.AttendanceRequest;
import com.osiki.hibernatedemo.payload.response.ApiResponse;
import com.osiki.hibernatedemo.payload.response.AttendanceResponse;
import com.osiki.hibernatedemo.repository.AttendanceRepository;
import com.osiki.hibernatedemo.repository.EmployeeRepository;
import com.osiki.hibernatedemo.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final EmployeeRepository employeeRepository;
    private final AttendanceRepository attendanceRepository;
    @Override
    public ResponseEntity<ApiResponse<AttendanceResponse>> registerAttendance(Long id, AttendanceRequest attendanceRequest) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new EmployeeDoesNotExistsException("Employee with ID " + id +  " does not exists"));


        Attendance attendance = Attendance.builder()
                .present(attendanceRequest.getPresent())
                .absent(attendanceRequest.getAbsent())
                .reasons(attendanceRequest.getReasons())
                .employee(employee)
                .build();

        attendanceRepository.save(attendance);



        AttendanceResponse response = AttendanceResponse.builder()
                .present(attendanceRequest.getPresent())
                .absent(attendance.getAbsent())
                .reasons(attendance.getReasons())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Attendance Mark Successfully", response));
    }
}
