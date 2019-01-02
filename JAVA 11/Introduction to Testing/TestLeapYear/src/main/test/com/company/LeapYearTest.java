package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeapYearTest {




    @Test
    public void leapYearsAreDivisibleByFour(){
        assertTrue(LeapYear.isLeap(2016));
    }

    @Test
    public void normalYearsAreNotDivisibleByFour(){
        assertFalse(LeapYear.isLeap(3));
    }

    @Test
    public void leapYearsAreNotDivisibleByHundred(){
        assertFalse(LeapYear.isLeap(1900));
    }

    @Test
    public void leapYearsAreDivisibleByFourHundred(){
        assertFalse(LeapYear.isLeap(2000));
    }





}