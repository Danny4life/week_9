package com.osiki.hibernatedemo.exception;

public class EmailNotSendException extends RuntimeException {
    public EmailNotSendException(String message) {
        super(message);
    }
}
