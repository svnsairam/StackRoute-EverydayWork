package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactorialTest {

    Factorial factorial;

    @Before
    public void setUp (){
        factorial = new Factorial();
    }

    @After
    public void tearDown(){
        factorial = null;
    }


    @Test
    public void testCornerCaseFor21(){
        long    expectedValue = -1;
        long    actualValue = factorial.factorial(21);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testFactorial(){

        long    expectedValue = 120;
        long    actualValue = factorial.factorial(5);

        assertEquals(expectedValue, actualValue);
    }



}