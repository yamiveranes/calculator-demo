package com.calculator.demo.util;

import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;

/**
 * Clase utilitaria de operaciones aritméticas
 */
public class CalculatorUtil {

    /**
     * Adiciona dos números
     * @param firstOperand primer operando
     * @param secondOperand segundo operando
     * @return suma de los números
     */
    public static Number addition(String firstOperand, String secondOperand){
        if( !(NumberUtils.isCreatable(firstOperand) && NumberUtils.isCreatable(secondOperand)))
            throw new NumberFormatException("Number format not valid");

        return new BigDecimal( firstOperand ).add( new BigDecimal(secondOperand ) );
    }

    /**
     * Resta dos números
     * @param firstOperand primer operando
     * @param secondOperand segundo operando
     * @return resta dos números
     */
    public static Number subtract(String firstOperand, String secondOperand){
        if( !(NumberUtils.isCreatable(firstOperand) && NumberUtils.isCreatable(secondOperand)))
            throw new NumberFormatException("Number format not valid");

        return new BigDecimal( firstOperand ).subtract( new BigDecimal(secondOperand ) );
    }

}
