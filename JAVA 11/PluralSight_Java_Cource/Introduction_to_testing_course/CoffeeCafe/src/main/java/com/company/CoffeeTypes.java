package com.company;

public enum CoffeeTypes {
    Latte(2,25),
    Espresso(7, 0),
    FilterCoffee(5,12);

    private final int requiredBeans;
    private final int requiredMilk;


    CoffeeTypes(int requiredBeans, int requiredMilk) {
        this.requiredBeans = requiredBeans;
        this.requiredMilk = requiredMilk;
    }

    public int getRequiredBeans(){
        System.out.println("Required beans = "+ requiredBeans);
        return requiredBeans;
    }

    public int getRequiredMilk(){
        return requiredMilk;
    }
}
