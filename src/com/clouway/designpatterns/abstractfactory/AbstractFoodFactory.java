package com.clouway.designpatterns.abstractfactory;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/15/11
 * Time: 4:47 PM
 */
public class AbstractFoodFactory {
    public FoodFactory createSpecificFactory(String name){
        if(name.equals("salad"))
            return new SaladFactory();
        if(name.equals("main"))
            return new MainMealFactory();
        return null;
    }
}
