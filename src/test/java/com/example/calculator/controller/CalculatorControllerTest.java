package com.example.calculator.controller;

import com.example.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;

    @Test
    public void testAdd() throws Exception {
        when(calculatorService.add(5.0, 3.0)).thenReturn(8.0);

        mockMvc.perform(get("/add").param("a", "5").param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(8.0));
    }

    @Test
    public void testSub() throws Exception {
        when(calculatorService.subtract(5.0, 3.0)).thenReturn(2.0);

        mockMvc.perform(get("/sub").param("a", "5").param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(2.0));
    }

    @Test
    public void testMul() throws Exception {
        when(calculatorService.multiply(5.0, 3.0)).thenReturn(15.0);

        mockMvc.perform(get("/mul").param("a", "5").param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(15.0));
    }

    @Test
    public void testDiv() throws Exception {
        when(calculatorService.divide(6.0, 3.0)).thenReturn(2.0);

        mockMvc.perform(get("/div").param("a", "6").param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(2.0));
    }

    @Test
    public void testDivByZero() throws Exception {
        when(calculatorService.divide(6.0, 0)).thenThrow(new IllegalArgumentException("Division by zero is not allowed"));

        mockMvc.perform(get("/div").param("a", "6").param("b", "0"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").value("Division by zero is not allowed"));
    }
}
