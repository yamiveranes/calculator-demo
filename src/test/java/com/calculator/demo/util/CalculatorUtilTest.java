package com.calculator.demo.util;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias de la clase CalculatorUtil
 */
class CalculatorUtilTest {

    @Test
    void add() {
        assertEquals(CalculatorUtil.addition("5", "67"), new BigDecimal("72"));
        assertEquals(CalculatorUtil.addition("-98", "67"), new BigDecimal("-31"));
        assertEquals( CalculatorUtil.addition("5.9", "67"), new BigDecimal("72.9"));
        assertEquals( CalculatorUtil.addition("3e2", "2.2"), new BigDecimal("302.2"));
    }

    @Test
    void addNotValidFormat() {

        Exception exception = assertThrows(NumberFormatException.class, () -> CalculatorUtil.addition("5++55", "67"));
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains("Number format not valid"));
    }

    @Test
    void sub() {
        assertEquals(CalculatorUtil.subtract("5", "67"), new BigDecimal("-62"));
        assertEquals(CalculatorUtil.subtract("67", "5"), new BigDecimal("62"));
        assertEquals( CalculatorUtil.subtract("67", "5.9" ), new BigDecimal("61.1"));
        assertEquals( CalculatorUtil.subtract("3e2", "2.2"), new BigDecimal("297.8"));
    }

    @Test
    void subNotValidFormat() {
        Exception exception = assertThrows(NumberFormatException.class, () -> CalculatorUtil.addition("78", "67sss"));
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains("Number format not valid"));
    }

}