package com.clouway.designpatterns.abstractfactory;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/15/11
 * Time: 5:15 PM
 */
public class Main {

    public static void main(String[] args) {

    AbstractFoodFactory abstractFoodFactory = new AbstractFoodFactory();
    FoodFactory foodOrdered = abstractFoodFactory.createSpecificFactory("salad");
    Food food = foodOrdered.takeOrder("green");
    food.cook();

    }
}
