package com.clouway.designpatterns.abstractfactory;

/**
 * Factory creating factories for the different food types
 * Created by Krasimir Dimitrov
 * Date: 12/15/11
 * Time: 4:47 PM
 */
public class AbstractFoodFactory {

    /**
     * create a specific food factory
     * @param name the name of the food for which we want a factory
     * @return the new food factory or null if there is no such factory
     */
    public FoodFactory createSpecificFactory(String name){
        if(name.equals("salad"))
            return new SaladFactory();
        if(name.equals("main"))
            return new MainMealFactory();
        return null;
    }
}
