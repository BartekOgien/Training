package com.examples.calculator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testEvaluate() {
        //Given
        Calculator calculator = new Calculator();
        //When
        double resultSameNumber = calculator.evaluate("31");
        double result = calculator.evaluate("5 + 2 * 3 * 2 + 5 / 5");
        double resultMultiply = calculator.evaluate("1.1 * 2.2 * 3.3");

        //Then
        assertEquals(31, resultSameNumber, 0.01);
        assertEquals(7.986, resultMultiply, 0.01);
        assertEquals(18, result, 0.01);
    }

    @Test
    public void testCos() {
        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        System.out.println(lista);
        lista.add(2, 20);
        lista.remove(1);
        System.out.println(lista);
    }


}