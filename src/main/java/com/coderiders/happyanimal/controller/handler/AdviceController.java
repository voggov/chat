package com.coderiders.happyanimal.controller.handler;

import com.coderiders.happyanimal.exceptions.BadRequestException;
import com.coderiders.happyanimal.exceptions.InternalServerException;
import com.coderiders.happyanimal.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceController {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    private static class ErrorDto {
        private String description;
    }

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<ErrorDto> handleBadRequestException(NotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorDto(ex.getLocalizedMessage()));
    }

    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity handleValidationExceptions(RuntimeException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(ex.getLocalizedMessage()));
    }

    @ExceptionHandler(value = {InternalServerException.class})
    public ResponseEntity handleInternalServerException(RuntimeException ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorDto(ex.getLocalizedMessage()));
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(ex.getLocalizedMessage()));
    }
}
