package com.calculator.demo.exception;

import com.calculator.demo.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;

/**
 * Manejador de excepciones global
 */
@ControllerAdvice
public class CalculatorExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler ( NumberFormatException.class)
    protected ResponseEntity<Object> handleNumberFormat(NumberFormatException ex) {

        ApiError err = new ApiError(HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                LocalDateTime.now(ZoneId.of("UTC")), Collections.emptyList());

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
}
