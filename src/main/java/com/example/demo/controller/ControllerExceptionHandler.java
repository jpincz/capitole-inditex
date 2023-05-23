package com.example.demo.controller;

import com.example.demo.dto.ErrorResponseDto;
import com.example.demo.exception.PriceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handlePriceNotFoundException(PriceNotFoundException ex) {
        ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGenericException(Exception ex) {
        ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
