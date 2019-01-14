package com.stackroute.javaPe2;
<<<<<<< HEAD:src/main/java/com/company/Palindrome.java

public class Palindrome {

    public static void main(String[] args) {


    }

    public String reverse(String inputString) {

        return null;
    }

    public boolean isPalindrome(String inputString) {
        return true;
    }


}
=======
import java.util.Scanner;
public class Q1_Palindrome {


    public String reverse(String inputString) {
    StringBuilder reversedString = new StringBuilder();
    int length = inputString.length();
    for(int i=0;i<inputString.length();i++)
    {
        reversedString.append(inputString.charAt(length - i -1));
    }        return reversedString.toString();
  }


  public  boolean isPalindrome(String inputString, String reversedString)
          {
    if(inputString == null)
        return false;
    if(inputString.equals(reversedString))
        return true;
    else
        return false;
          }
   }
>>>>>>> f6053cc9f689ecf1eb01cf995cfe00b2c9d313e8:src/main/java/com/company/Q1_Palindrome.java
