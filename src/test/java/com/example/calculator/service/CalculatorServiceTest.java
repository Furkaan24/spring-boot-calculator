package com.example.calculator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void testAdd() {
        assertEquals(8.0, calculatorService.add(5.0, 3.0));
    }

    @Test
    public void testSubtract() {
        assertEquals(2.0, calculatorService.subtract(5.0, 3.0));
    }

    @Test
    public void testMultiply() {
        assertEquals(15.0, calculatorService.multiply(5.0, 3.0));
    }

    @Test
    public void testDivide() {
        assertEquals(2.0, calculatorService.divide(6.0, 3.0));
    }

    @Test
    public void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(6.0, 0));
    }
}
