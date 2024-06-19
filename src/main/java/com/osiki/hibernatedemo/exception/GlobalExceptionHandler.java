package com.osiki.hibernatedemo.exception;

import com.osiki.hibernatedemo.payload.response.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorDetails>handleEmailAlreadyExistsException(final EmailAlreadyExistsException e){
        ErrorDetails errorResponse = new ErrorDetails();
        errorResponse.setTimeStamp(LocalDateTime.now());
        errorResponse.setErrorMessage(e.getMessage());
        errorResponse.setErrorDetails(String.valueOf(HttpStatus.CONFLICT));

        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);

    }

    @ExceptionHandler(EmployeeDoesNotExistsException.class)
    public ResponseEntity<ErrorDetails>handleEmployeeDoesNotExistsException(final EmployeeDoesNotExistsException e){
        ErrorDetails errorResponse = new ErrorDetails();
        errorResponse.setTimeStamp(LocalDateTime.now());
        errorResponse.setErrorMessage(e.getMessage());
        errorResponse.setErrorDetails(String.valueOf(HttpStatus.NOT_FOUND));

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }
}
