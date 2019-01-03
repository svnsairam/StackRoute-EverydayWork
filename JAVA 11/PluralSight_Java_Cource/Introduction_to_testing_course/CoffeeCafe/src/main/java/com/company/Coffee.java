package com.company;

public final class Coffee {

    private final CoffeeTypes type;
    private final int beans;
    private final  int milk;

    public Coffee(CoffeeTypes coffeeType, int beans, int milk){
        this.type = coffeeType;
        this.beans = beans;
        this.milk = milk;
    }

    public CoffeeTypes getType(){
        return  type;
    }
    public int getBeans (){
        return beans;
    }

    public int getMilk(){
        return milk;
    }

    public String toString(){
        return "Coffee " + "type = " + type + "beans = "+ beans + " milk = "+milk;
    }


}
