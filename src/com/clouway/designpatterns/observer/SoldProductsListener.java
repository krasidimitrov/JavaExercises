package com.clouway.designpatterns.observer;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/26/11
 * Time: 5:59 PM
 */
public interface SoldProductsListener {
    public void onProductSell(String name, int quantitySold);
}
