package com.company;

public class LeapYear {

    public static boolean isLeap(int year){

        return isDivisible(year,4) && ((!isDivisible(year,100)) || (isDivisible(year,400)));
    }

    public  static boolean isDivisible(int year, int denominator){
        return (year%denominator == 0);
    }

}
