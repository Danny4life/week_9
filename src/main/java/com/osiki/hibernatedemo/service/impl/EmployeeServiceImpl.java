package com.osiki.hibernatedemo.service.impl;

import com.osiki.hibernatedemo.entites.enums.Role;
import com.osiki.hibernatedemo.entites.model.Employee;
import com.osiki.hibernatedemo.exception.EmailAlreadyExistsException;
import com.osiki.hibernatedemo.payload.request.EmailDetails;
import com.osiki.hibernatedemo.payload.request.EmployeeRequest;
import com.osiki.hibernatedemo.payload.response.ApiResponse;
import com.osiki.hibernatedemo.payload.response.EmployeeResponse;
import com.osiki.hibernatedemo.repository.EmployeeRepository;
import com.osiki.hibernatedemo.service.EmailService;
import com.osiki.hibernatedemo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmailService emailService;
    @Override
    public ResponseEntity<ApiResponse<EmployeeResponse>> registerEmployee(EmployeeRequest employeeRequest) {
        boolean isEmailPresent = employeeRepository.existsByEmail(employeeRequest.getEmail());

        if(isEmailPresent){
            throw new EmailAlreadyExistsException("Email Already Exists");
        }

        Employee newEmployee = Employee.builder()
                .firstName(employeeRequest.getFirstName())
                .lastName(employeeRequest.getLastName())
                .email(employeeRequest.getEmail())
                .password(employeeRequest.getPassword())
                .designation(employeeRequest.getDesignation())
                .gender(employeeRequest.getGender())
                .role(Role.USER)
                .build();

        Employee saveEmployee = employeeRepository.save(newEmployee);

        // send email alert
        EmailDetails emailDetails = EmailDetails.builder()
                .recipient(saveEmployee.getEmail())
                .subject("ACCOUNT CREATION")
                .messageBody("CONGRATULATIONS!!! Your Employee Account Has Been Successfully Created.\n Your Account Details: \n" +
                        "Account FullName: " + saveEmployee.getFirstName() + " " + saveEmployee.getLastName())
                .build();

        emailService.sendEmailAlert(emailDetails);


        EmployeeResponse response = EmployeeResponse.builder()
                .firstName(employeeRequest.getFirstName())
                .lastName(employeeRequest.getLastName())
                .email(employeeRequest.getEmail())
                .designation(employeeRequest.getDesignation())
                .gender(employeeRequest.getGender())
                .build();


        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Account Created Successfully", response));


    }
}
