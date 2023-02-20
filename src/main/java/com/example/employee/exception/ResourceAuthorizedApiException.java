package com.example.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class ResourceAuthorizedApiException extends RuntimeException{
    public ResourceAuthorizedApiException(String message) {
        super(message);
    }
}
