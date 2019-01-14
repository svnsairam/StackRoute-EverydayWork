package com.stackroute.javaPe2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q6_StudentsAndGradesTest {

    Q6_StudentsAndGrades testObj;
    final int no_of_students = 4;
    final int[] grades = {86, 65, 98, 77};

    @Before
    public void setUp (){
        testObj = new Q6_StudentsAndGrades();
    }

    @After
    public void tearDown(){
        testObj = null;
    }

    @Test
    public void testCornerCaseIntergerMaxValue(){
        int expectedValue = Integer.MAX_VALUE;
        int grades[] = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int actualValue = testObj.maximumGrade(no_of_students, grades);

        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testCornerCaseMinimumGrade(){
        int expectedValue = Integer.MIN_VALUE;

        int grades[] = {Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE};


        int actualValue = testObj.minimumGrade(no_of_students, grades);

        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testAverageGrade(){
        double expectedValue = 81.50;

        double actualValue = testObj.averageGrade(no_of_students, grades);

        assertEquals(expectedValue,actualValue, 0);
    }

    @Test
    public void testMinimumGrade(){
        int expectedValue = 65;

        int actualValue = testObj.minimumGrade(no_of_students, grades);

        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testMaximumGrade(){
        int expectedValue = 98;

        int actualValue = testObj.maximumGrade(no_of_students, grades);

        assertEquals(expectedValue,actualValue);
    }
}