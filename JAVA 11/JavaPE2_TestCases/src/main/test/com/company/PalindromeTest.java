package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeTest {

    Palindrome palindrome;

    @Before
    public void setUp (){
        palindrome = new Palindrome();
    }

    @After
    public void tearDown(){
        palindrome = null;
    }


    @Test
    public  void testReveseSuccess(){

        String expectedValue = "aabbcbbaa";
        String actualValue = palindrome.reverse("aabbcbbaa");

        assertEquals(expectedValue, actualValue);


        expectedValue = "abcd";
        actualValue = palindrome.reverse("dcba");


    }

    @Test
    public  void testReveseFailure(){

        String expectedValue = "abcd";
        String actualValue = palindrome.reverse("acdb");

        assertNotEquals(expectedValue, actualValue);

    }

    @Test
    public  void testPalindromeSuccess(){

        boolean expectedValue = true;
        boolean actualValue = palindrome.isPalindrome(palindrome.reverse("aba"));

        assertEquals(expectedValue, actualValue);

    }

    @Test
    public  void testPalindromeFailure(){

        boolean expectedValue = true;
        boolean actualValue = palindrome.isPalindrome(palindrome.reverse("aba"));

        assertNotNull(actualValue);
        assertNotEquals(expectedValue, actualValue);

    }



}