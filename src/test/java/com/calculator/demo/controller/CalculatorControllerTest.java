package com.calculator.demo.controller;

import com.calculator.demo.model.CalculatorResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test unitarios de la clase CalculatorController
 */
class CalculatorControllerTest {

    private final CalculatorController controller = new CalculatorController();;

    @Test
    void addition() {
        ResponseEntity<CalculatorResponse> response = controller.addition("98.2", "67.3");
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void subtract() {
        ResponseEntity<CalculatorResponse> response = controller.addition("98.2", "67.3");
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
}