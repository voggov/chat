package com.coderiders.happyanimal.controller.handler;

import com.coderiders.happyanimal.exceptions.BadRequestException;
import com.coderiders.happyanimal.exceptions.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity handleBadRequestException(RuntimeException ex, WebRequest webRequest) {
        return handleExceptionInternal(ex,
                "Ошибка, код 404 " + ex.getMessage(),
                new HttpHeaders(),
                HttpStatus.NOT_FOUND,
                webRequest);
    }

    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity handleValidationExceptions(RuntimeException ex, WebRequest webRequest) {
        return handleExceptionInternal(ex,
                "Ошибка, код 400 " + ex.getMessage(),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST,
                webRequest);
    }
}
