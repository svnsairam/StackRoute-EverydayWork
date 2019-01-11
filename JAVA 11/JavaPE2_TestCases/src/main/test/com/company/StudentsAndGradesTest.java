package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentsAndGradesTest {

    StudentsAndGrades studentsAndGrades;
    final int noOfStudents = 4;
    final int[] grades = {86, 65, 98, 77};

    @Before
    public void setUp (){
        studentsAndGrades = new StudentsAndGrades();
    }

    @After
    public void tearDown(){
        studentsAndGrades = null;
    }

    @Test
    public void testCornerCaseIntergerMaxValue(){
        int expectedValue = 98;
        int grades[] = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int actualValue = studentsAndGrades.maximumGrade(noOfStudents, grades);

        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testAverageGrade(){
        double expectedValue = 81.50;

        double actualValue = studentsAndGrades.averageGrade(noOfStudents, grades);

        assertEquals(expectedValue,actualValue, 0);
    }

    @Test
    public void testMinimumGrade(){
        int expectedValue = 65;

        int actualValue = studentsAndGrades.maximumGrade(noOfStudents, grades);

        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testMaximumGrade(){
        int expectedValue = 98;

        int actualValue = studentsAndGrades.maximumGrade(noOfStudents, grades);

        assertEquals(expectedValue,actualValue);
    }





}