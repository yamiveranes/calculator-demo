package com.calculator.demo.aspect;


import com.calculator.demo.model.CalculatorResponse;
import io.corp.calculator.TracerImpl;
import lombok.AllArgsConstructor;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Aspecto responsable de tracear los resultados de las operaciones
 * del controlador
 */
@Aspect
@Component
@AllArgsConstructor
public class CalculatorTracerAspect {

    private final TracerImpl tracer;

    @AfterReturning(pointcut = "execution(* com.calculator.demo.controller.CalculatorController.* (..))", returning = "result")
    public void doAccessCheck(Object result) {
        CalculatorResponse response = ((ResponseEntity<CalculatorResponse>) result).getBody();

        tracer.trace(response.getResult());
    }

}
