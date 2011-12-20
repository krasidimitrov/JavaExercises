package com.clouway.designpatterns.storeobservation;

/**
 * Observer interface
 * Created by Krasimir Dimitrov
 * Date: 12/19/11
 * Time: 4:41 PM
 */
public interface ObserverForAvailableProducts {

    public void updateOnProductAdd(String name, Integer quantity);

    public void updateOnProductSell(String name, Integer quantity);
}
