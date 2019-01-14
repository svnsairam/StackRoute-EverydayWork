package com.stackroute.javaPe2;

public class Q3_Member{
    String  MemName;
    int     MemAge, MemSalary;


    Q3_Member (String name, int age , int salary){
        this.MemName = name;
        this.MemAge = age;
        this.MemSalary = salary;
    }



}

class  MemberVariable {

    Q3_Member memObject ;

    public MemberVariable(String name , int age, int salary) {

          memObject  = new Q3_Member(name,age,salary);
    }


    public String getName(){
        return memObject.MemName;
    }

    public int getAge(){
        return memObject.MemAge;
    }

    public int getSalary(){
        return memObject.MemSalary;
    }


}