package com.osiki.hibernatedemo.service;

import com.osiki.hibernatedemo.payload.request.AttendanceRequest;
import com.osiki.hibernatedemo.payload.response.ApiResponse;
import com.osiki.hibernatedemo.payload.response.AttendanceResponse;
import org.springframework.http.ResponseEntity;

public interface AttendanceService {
    ResponseEntity<ApiResponse<AttendanceResponse>> registerAttendance(Long id, AttendanceRequest attendanceRequest);
}
