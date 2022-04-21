package com.junit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void test(){
        Calculator c = new Calculator();
        int result = c.add(1, 2);
        assertEquals(3, result);
        assertTrue(result > 0);
    }
    @Disabled
    @DisplayName("測試除法問題")
    @Test
    public void divide(){
        Calculator c = new Calculator();
        assertThrows(ArithmeticException.class,()->{
            c.divide(1,0);
        });
    }

}