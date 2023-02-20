package com.example.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundApiException extends RuntimeException{
    public ResourceNotFoundApiException(String message) {
        super(message);
    }
}
