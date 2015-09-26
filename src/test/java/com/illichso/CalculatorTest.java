package com.illichso;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
//    @Mock
    private Calculator calculator;

    @Before
    public void setUp() {
//        MockitoAnnotations.initMocks(this);
        calculator = new Calculator();

    }

    @Test
    public void testAbs() {
//        when(calculator.abs(-20)).thenReturn(21);
        assertEquals(20,calculator.abs(-20));

    }
}
