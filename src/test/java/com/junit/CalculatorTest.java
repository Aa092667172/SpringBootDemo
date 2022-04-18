package com.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    public void test(){
        Calculator c = new Calculator();
        int result = c.add(1, 2);
        assertEquals(3, result);
    }
}