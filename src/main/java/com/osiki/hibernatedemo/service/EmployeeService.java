package com.osiki.hibernatedemo.service;

import com.osiki.hibernatedemo.payload.request.EmployeeRequest;
import com.osiki.hibernatedemo.payload.response.ApiResponse;
import com.osiki.hibernatedemo.payload.response.EmployeeResponse;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {
    ResponseEntity<ApiResponse<EmployeeResponse>> registerEmployee(EmployeeRequest employeeRequest);
}
