package com.company;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;

import static org.junit.Assert.*;

public class CafeTest {


    public  static final int NO_BEANS = 0;
    public  static final int ESPRESSO_BEANS = CoffeeTypes.Espresso.getRequiredBeans();
    public static final int NO_MILK = 0;

    private Cafe cafe;
    // Test can brew espresso

    @Test
    public void canBrewEspresso(){

        // GIVEN CLAUSE
        // restock the beans
        withBeans();

        // WHEN CLAUSE
        Coffee coffee = cafe.brew(CoffeeTypes.Espresso);


        // THEN CLAUSE

        Assert.assertEquals("Wrong number of beans ",CoffeeTypes.Espresso, coffee.getType());

        // Is there No milk

        Assert.assertEquals("Wrong amount of milk ",NO_MILK, coffee.getMilk());

        // Sufficient beans

        Assert.assertEquals("Wrong coffee type ",ESPRESSO_BEANS, coffee.getBeans());
    }

    @Test
    public void brewingEspressoConsumesBeans(){
        // GIVEN CLAUSE
        // restock the beans
        withBeans();

        // WHEN CLAUSE
        Coffee coffee = cafe.brew(CoffeeTypes.Espresso);

        // THEN CLAUSE
        Assert.assertEquals(NO_BEANS,cafe.getBeansInStock());

    }

    // THEN CLAUSE is present in @Test i.e IllegalStateException is ok and plese neglect this kind of exception.
    @Test(expected = IllegalStateException.class)
    public void  latteRequiresMilk(){

        // GIVEN CLAUSE
        // restock the beans
        withBeans();

        // When Clause
        cafe.brew(CoffeeTypes.Latte);
    }

    @Before
    public void before(){
        cafe = new Cafe();
    }

    private Cafe withBeans(){
        cafe.restockBeans(7);
        return cafe;
    }


}