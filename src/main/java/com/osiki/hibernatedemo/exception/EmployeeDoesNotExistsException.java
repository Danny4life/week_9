package com.osiki.hibernatedemo.exception;

public class EmployeeDoesNotExistsException extends RuntimeException{
    public EmployeeDoesNotExistsException(String message) {
        super(message);
    }
}
