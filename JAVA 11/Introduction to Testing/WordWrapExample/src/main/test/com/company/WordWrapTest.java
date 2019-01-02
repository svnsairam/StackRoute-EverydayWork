package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordWrapTest {

    public static final int LINE_LENGTH = 5;

    // A method that breaks words on specified space with new line. like a word processor would.


    @Test
    public void lineShouldWrapIfOverLineLength(){
        String result = WordWrap.wrap("The Sleepy", LINE_LENGTH);
        assertEquals("The S\nleepy", result);
    }

    @Test
    public void shortLinesShouldNotWrap(){
        String result = WordWrap.wrap("The", LINE_LENGTH);
        assertEquals("The", result);
    }


    @Test
    public void longLinesShouldWrapMultiplesTimesOfGivenLength(){
        String result = WordWrap.wrap("The Brew And Barbique", LINE_LENGTH);
        assertEquals("The B\nrew An\nd Bar\nbique\n", result);

    }

}