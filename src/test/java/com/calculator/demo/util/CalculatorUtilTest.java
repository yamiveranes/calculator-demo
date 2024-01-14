package com.calculator.demo.util;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorUtilTest {

    @Test
    void add() {
        assertEquals(CalculatorUtil.add("5", "67"), new BigDecimal("72"));
        assertEquals(CalculatorUtil.add("-98", "67"), new BigDecimal("-31"));
        assertEquals( CalculatorUtil.add("5.9", "67"), new BigDecimal("72.9"));
        assertEquals( CalculatorUtil.add("3e2", "2.2"), new BigDecimal("302.2"));
    }

    @Test
    void addNotValidFormat() {

        Exception exception = assertThrows(NumberFormatException.class, () -> CalculatorUtil.add("5++55", "67"));
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains("Number format not valid"));
    }

    @Test
    void sub() {
        assertEquals(CalculatorUtil.sub("5", "67"), new BigDecimal("-62"));
        assertEquals(CalculatorUtil.sub("67", "5"), new BigDecimal("62"));
        assertEquals( CalculatorUtil.sub("67", "5.9" ), new BigDecimal("61.1"));
        assertEquals( CalculatorUtil.sub("3e2", "2.2"), new BigDecimal("297.8"));
    }

    @Test
    void subNotValidFormat() {
        Exception exception = assertThrows(NumberFormatException.class, () -> CalculatorUtil.add("78", "67sss"));
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains("Number format not valid"));
    }

}