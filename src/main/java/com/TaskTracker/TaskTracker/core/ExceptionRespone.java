package com.TaskTracker.TaskTracker.core;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ExceptionRespone {
    private final HttpStatus status;
    private final String message;

    public ExceptionRespone(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

}
