package com.clouway.designpatterns.storeobservation;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/19/11
 * Time: 12:57 PM
 */
public class SoldProducts implements ObserverForSoldProducts {
    public Map<String, Integer> soldProductsList;

    public SoldProducts(Map<String, Integer> list) {
        soldProductsList = new Hashtable<String, Integer>();
    }

    public void update(String name, Integer quantity) {
        if (soldProductsList.containsKey(name)) {
            soldProductsList.put(name, soldProductsList.get(name) + quantity);
        } else {
            soldProductsList.put(name, quantity);
        }
    }
}
