package com.company;

public class Cafe {

    private int beansInStock =0 ;
    private  int milkInStock = 0;

    public  Coffee brew(CoffeeTypes coffeeType){

        return brew(coffeeType,1);
    }

    public Coffee brew(CoffeeTypes coffeeType, int quantity){
        requiredPositive(quantity);
        int requiredBeans = coffeeType.getRequiredBeans() * quantity;
        int requiredMilk = coffeeType.getRequiredMilk() * quantity;
        System.out.println("Hai I  am here "+beansInStock+" "+quantity);

        if((requiredBeans > beansInStock) || (requiredMilk > milkInStock)){
            throw new IllegalStateException("Insufficient beans or milk");
        }

        beansInStock = beansInStock - requiredBeans;
        milkInStock = milkInStock - requiredMilk;
        return  new Coffee(coffeeType, requiredBeans, requiredMilk);

    }


    public  void  restockBeans(int weightInGrams){
        requiredPositive(weightInGrams);
        beansInStock = beansInStock + weightInGrams;
        System.out.println("Hai I  am here "+beansInStock);
    }

    public  void  restockMilk(int weightInGrams){
        requiredPositive(weightInGrams);
        milkInStock = milkInStock + weightInGrams;
    }

    private void requiredPositive(int value){
        if(value < 1){
            throw new IllegalArgumentException();
        }
    }

    public  int getBeansInStock(){
        return beansInStock;
    }

    public int getMilkInStock(){
        return milkInStock;
    }

}
