package com.stackroute.javaPe2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MemberVariableTest {

    MemberVariable memberVariable;
    final int no_of_students = 4;
    final int[] grades = {86, 65, 98, 77};

    @Before
<<<<<<< HEAD
    public void setUp() {
        memberVariable = new MemberVariable("sachin", 45, 225000);
=======
    public void setUp (){
        testObj = new MemberVariable("srinivas", 55, 75000 );
>>>>>>> f6053cc9f689ecf1eb01cf995cfe00b2c9d313e8
    }

    @After
    public void tearDown() {
        memberVariable = null;
    }

    @Test
<<<<<<< HEAD
    public void testNameAgeSalary() {
        String expectedName = "sachin";
        String actualName = memberVariable.getName();
=======
    public  void testNameAgeSalary(){
        String expectedName =  "srinivas";
        String actualName = testObj.getName();
>>>>>>> f6053cc9f689ecf1eb01cf995cfe00b2c9d313e8

        assertEquals(expectedName, actualName);


<<<<<<< HEAD
        int expectedAge = 45;
        int actualAge = memberVariable.getAge();
=======
        int     expectedAge  =  55;
        int     actualAge    =  testObj.getAge();
>>>>>>> f6053cc9f689ecf1eb01cf995cfe00b2c9d313e8

        assertEquals(expectedAge, actualAge);


<<<<<<< HEAD
        int expectedSalary = 225000;
        int actualSalary = memberVariable.getSalary();
=======
        int     expectedSalary  =  75000;
        int     actualSalary   =  testObj.getSalary();
>>>>>>> f6053cc9f689ecf1eb01cf995cfe00b2c9d313e8

        assertEquals(expectedSalary, actualSalary);

    }


}