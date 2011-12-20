package com.clouway.designpatterns.abstractfactory;

/**
 * Factory for the main meal foods
 * Created by Krasimir Dimitrov
 * Date: 12/15/11
 * Time: 4:22 PM
 */
public class MainMealFactory implements FoodFactory {

    /**
     * create(cook) the reuired food
     *
     * @param name the name of the food that we want to cook
     * @return the food that is cooked or null if there is no such food
     */
    public Food takeOrder(String name) {
        if (name.equals("fish"))
            return new Fish();
        if (name.equals("steak"))
            return new Steak();
        return null;
    }
}
