package me.jamieburns.springboot2.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeControllerExceptionHandler {

    @ExceptionHandler( RuntimeException.class )
    @ResponseStatus( org.springframework.http.HttpStatus.NOT_FOUND )
    public String handleRuntimeException( RuntimeException e ) {
        return e.getMessage();
    }
}
