package com.example.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CREATED)
public class ResourceCreatedApiException extends RuntimeException{
    public ResourceCreatedApiException(String message) {
        super(message);
    }
}
