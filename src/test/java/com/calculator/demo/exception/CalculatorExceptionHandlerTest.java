package com.calculator.demo.exception;

import com.calculator.demo.model.ApiError;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Pruebas unitarias de la clase CalculatorExceptionHandler
 */
class CalculatorExceptionHandlerTest {

    private final CalculatorExceptionHandler handler = new  CalculatorExceptionHandler();

    @Test
    void handleNumberFormat() {
        final String message = "Number format not valid";
        final ResponseEntity<Object> handled = handler.handleNumberFormat(new NumberFormatException(message));

        assertEquals(HttpStatus.NOT_FOUND, handled.getStatusCode());
        assertTrue(handled.getBody() instanceof ApiError);

        ApiError err = (ApiError) handled.getBody();

        assertEquals(HttpStatus.BAD_REQUEST.value(), err.getStatus());
        assertEquals(message, err.getMessage());
    }
}