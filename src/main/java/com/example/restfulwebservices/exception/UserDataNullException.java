package com.example.restfulwebservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class UserDataNullException extends RuntimeException{

    public UserDataNullException(String message) {
        super(message);
    }
    
}
