package com.clouway.designpatterns.abstractfactory;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/15/11
 * Time: 3:16 PM
 */
public class SaladFactory implements FoodFactory{
    public Food takeOrder(String name){
        if(name.equals("green"))
            return new GreenSalad();
        if(name.equals("sea"))
            return new SeaSalad();
        return null;
    }
}
