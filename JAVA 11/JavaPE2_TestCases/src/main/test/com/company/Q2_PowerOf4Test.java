package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q2_PowerOf4Test {

    Q2_PowerOf4 testObj;

    @Before
    public void setUp (){
        testObj = new Q2_PowerOf4();
    }

    @After
    public void tearDown(){
        testObj = null;
    }

    @Test
    public void testForCornerCasesZero(){
        boolean expectedValue = false;
        boolean actualValue = testObj.isPowerOf4(0);

        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testNegativeNumbersFailure(){
        boolean expectedValue = false;
        boolean actualValue = testObj.isPowerOf4(-256);

        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testAsciiCharecterFailure(){
        boolean expectedValue = false;
        boolean actualValue = testObj.isPowerOf4('@');

        assertEquals(expectedValue,actualValue);
    }


    @Test
    public void testPowerOfFourSuccess(){
        boolean expectedValue = true;
        boolean actualValue = testObj.isPowerOf4(16);

        assertEquals(expectedValue,actualValue);

    }

    @Test
    public void testPowerOfFourFailure(){
        boolean expectedValue = false;
        boolean actualValue = testObj.isPowerOf4(2445);

        assertEquals(expectedValue,actualValue);
    }







}