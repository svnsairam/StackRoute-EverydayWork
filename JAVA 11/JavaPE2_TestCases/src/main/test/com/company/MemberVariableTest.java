package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MemberVariableTest {

    MemberVariable memberVariable;
    final int no_of_students = 4;
    final int[] grades = {86, 65, 98, 77};

    @Before
    public void setUp (){
        memberVariable = new MemberVariable("sachin", 45, 225000 );
    }

    @After
    public void tearDown(){
        memberVariable = null;
    }

    @Test
    public  void testNameAgeSalary(){
        String expectedName =  "sachin";
        String actualName = memberVariable.getName();

        assertEquals(expectedName, actualName);


        int     expectedAge  =  45;
        int     actualAge    =  memberVariable.getAge();

        assertEquals(expectedAge,actualAge);


        int     expectedSalary  =  225000;
        int     actualSalary   =  memberVariable.getSalary();

        assertEquals(expectedSalary,actualSalary);

    }


}