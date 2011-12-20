package com.clouway.designpatterns.abstractfactory;

/**
 * interface for the food factories
 * Created by Krasimir Dimitrov
 * Date: 12/15/11
 * Time: 3:07 PM
 */
public interface FoodFactory {
    public Food takeOrder(String name);
}
