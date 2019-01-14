package com.stackroute.javaPe2;

public class Q2_PowerOf4 {
    public  static  void  main(String arg[]){
        //System.out.println(isPowerOf4(-16));
    }

    public  boolean isPowerOf4(int inputInt){ // Method to check whether number is power of four or not


        while(inputInt>0 && inputInt%4==0)
        {
            inputInt=inputInt/4;

        }
        if(inputInt==1)
        {
            System.out.println("true");
            return true;
        }
        else {
            System.out.println("false");
            return false;
        }

    }
}
