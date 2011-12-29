package com.clouway.designpatterns.observer;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/26/11
 * Time: 4:07 PM
 */
public interface AvailableProductsListener {
    void onNewProductAdd(String productName);
}
