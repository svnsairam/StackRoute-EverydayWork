package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PowerOf4Test {

    PowerOf4 powerOf4;

    @Before
    public void setUp (){
        powerOf4 = new PowerOf4();
    }

    @After
    public void tearDown(){
        powerOf4 = null;
    }

    @Test
    public void testForCornerCasesZero(){
        boolean expectedValue = false;
        boolean actualValue = powerOf4.isPowerOf4(0);

        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testNegativeNumbersFailure(){
        boolean expectedValue = false;
        boolean actualValue = powerOf4.isPowerOf4(-256);

        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testAsciiCharecterFailure(){
        boolean expectedValue = false;
        boolean actualValue = powerOf4.isPowerOf4('@');

        assertEquals(expectedValue,actualValue);
    }


    @Test
    public void testPowerOfFourSuccess(){
        boolean expectedValue = true;
        boolean actualValue = powerOf4.isPowerOf4(16);

        assertEquals(expectedValue,actualValue);

    }

    @Test
    public void testPowerOfFourFailure(){
        boolean expectedValue = false;
        boolean actualValue = powerOf4.isPowerOf4(2445);

        assertEquals(expectedValue,actualValue);
    }







}