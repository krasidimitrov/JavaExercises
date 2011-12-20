package com.clouway.designpatterns.abstractfactory;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/15/11
 * Time: 4:22 PM
 */
public class MainMealFactory implements FoodFactory{

    public Food takeOrder(String name){
        if(name.equals("fish"))
            return new Fish();
        if(name.equals("steak"))
            return new Steak();
        return null;
    }
}
