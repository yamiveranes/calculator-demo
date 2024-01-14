package com.calculator.demo.controller;

import com.calculator.demo.model.CalculatorResponse;
import com.calculator.demo.util.CalculatorUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController implements CalculatorApi {
    @Override
    public ResponseEntity<CalculatorResponse> addition( String firstOperand, String secondOperand){
        Number result = CalculatorUtil.addition(firstOperand, secondOperand);
        return ResponseEntity.ok(new CalculatorResponse(result.toString()));
    }

    @Override
    public ResponseEntity<CalculatorResponse> subtract( String firstOperand, String secondOperand){
        Number result = CalculatorUtil.subtract(firstOperand, secondOperand);
        return ResponseEntity.ok(new CalculatorResponse(result.toString()));
    }
}
