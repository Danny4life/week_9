package com.osiki.hibernatedemo.controller;

import com.osiki.hibernatedemo.payload.request.EmployeeRequest;
import com.osiki.hibernatedemo.payload.response.ApiResponse;
import com.osiki.hibernatedemo.payload.response.EmployeeResponse;
import com.osiki.hibernatedemo.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee/")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("register")
    public ResponseEntity<ApiResponse<EmployeeResponse>> registerEmployee(@Valid @RequestBody EmployeeRequest employeeRequest){
        return employeeService.registerEmployee(employeeRequest);
    }
}
