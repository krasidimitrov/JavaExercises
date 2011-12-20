package com.clouway.designpatterns.storeobservation;

/**
 * Observer interface
 * Created by Krasimir Dimitrov
 * Date: 12/19/11
 * Time: 3:58 PM
 */
public interface ObserverForSoldProducts {

    public void update(String name, Integer quantity);
}
