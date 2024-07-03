package com.example.calculator.controller;

import com.example.calculator.model.CalculationResult;
import com.example.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/add")
    public CalculationResult add(@RequestParam double a, @RequestParam double b) {
        double result = calculatorService.add(a, b);
        return new CalculationResult(result);
    }

    @GetMapping("/sub")
    public CalculationResult sub(@RequestParam double a, @RequestParam double b) {
        double result = calculatorService.subtract(a, b);
        return new CalculationResult(result);
    }

    @GetMapping("/mul")
    public CalculationResult mul(@RequestParam double a, @RequestParam double b) {
        double result = calculatorService.multiply(a, b);
        return new CalculationResult(result);
    }

    @GetMapping("/div")
    public CalculationResult div(@RequestParam double a, @RequestParam double b) {
        double result = calculatorService.divide(a, b);
        return new CalculationResult(result);
    }
}
