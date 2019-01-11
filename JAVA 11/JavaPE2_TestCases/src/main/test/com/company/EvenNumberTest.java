package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EvenNumberTest {

    EvenNumber testObj;

    @Before
    public void setUp (){
        testObj = new EvenNumber();
    }

    @After
    public void tearDown(){
        testObj = null;
    }

    @Test
    public void testEvenNumberSuccess(){

        boolean expectedValue = true;
        boolean actualValue = testObj.isEven(434);

        assertEquals(expectedValue,actualValue);

        expectedValue = true;
        actualValue = testObj.isEven(-256);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testEvenNumberFailure(){

        boolean expectedValue = false;
        boolean actualValue = testObj.isEven(25);

        assertEquals(expectedValue,actualValue);
    }

}