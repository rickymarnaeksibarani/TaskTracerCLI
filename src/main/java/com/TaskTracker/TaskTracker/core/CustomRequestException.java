package com.TaskTracker.TaskTracker.core;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
public class CustomRequestException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(CustomRequestException.class);
    private final HttpStatus status;


    public CustomRequestException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public ResponseEntity<ExceptionRespone> GlobalCustomRequestException(String message, HttpStatus status) {
        logger.error("An error occurred: {}", getMessage());
        return new ResponseEntity<>(new ExceptionRespone(status, message), status);
    }
}