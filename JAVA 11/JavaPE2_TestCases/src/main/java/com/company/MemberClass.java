package com.company;

public class MemberClass {
    String  MemberName;
    int     MemberAge, MemberSalary;


    MemberClass (String name, int age , int salary){
        this.MemberName = name;
        this.MemberAge = age;
        this.MemberSalary = salary;
    }



}

class  MemberVariable {

    MemberClass memberObject ;

    public MemberVariable(String name , int age, int salary) {

          memberObject  = new MemberClass(name,age,salary);
    }


    public String getName(){
        return memberObject.MemberName;
    }

    public int getAge(){
        return memberObject.MemberAge;
    }

    public int getSalary(){
        return memberObject.MemberSalary;
    }


}