package com.osiki.hibernatedemo.controller;

import com.osiki.hibernatedemo.payload.request.AttendanceRequest;
import com.osiki.hibernatedemo.payload.response.ApiResponse;
import com.osiki.hibernatedemo.payload.response.AttendanceResponse;
import com.osiki.hibernatedemo.service.AttendanceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/attendance/")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;

    @PostMapping("mark-attendance/{id}")
    public ResponseEntity<ApiResponse<AttendanceResponse>> markAttendance(@PathVariable Long id, @RequestBody AttendanceRequest attendanceRequest){
        return attendanceService.registerAttendance(id, attendanceRequest);
    }
}
