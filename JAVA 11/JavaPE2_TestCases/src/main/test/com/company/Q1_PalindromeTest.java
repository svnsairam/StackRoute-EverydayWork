package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q1_PalindromeTest {

    Q1_Palindrome testObj;

    @Before
    public void setUp (){
        testObj = new Q1_Palindrome();
    }

    @After
    public void tearDown(){
        testObj = null;
    }


    @Test
    public  void testReveseSuccess(){

        String expectedValue = "aabbcbbaa";
        String actualValue = testObj.reverse("aabbcbbaa");

        assertEquals(expectedValue, actualValue);


        expectedValue = "abcd";
        actualValue = testObj.reverse("dcba");


    }

    @Test
    public  void testReveseFailure(){

        String expectedValue = "abcd";
        String actualValue = testObj.reverse("acdb");

        assertNotEquals(expectedValue, actualValue);

    }

    @Test
    public  void testPalindromeSuccess(){

        boolean expectedValue = true;
        boolean actualValue = testObj.isPalindrome(testObj.reverse("aba"));

        assertEquals(expectedValue, actualValue);

    }

    @Test
    public  void testPalindromeFailure(){

        boolean expectedValue = true;
        boolean actualValue = testObj.isPalindrome(testObj.reverse("aba"));

        assertNotNull(actualValue);
        assertNotEquals(expectedValue, actualValue);

    }



}