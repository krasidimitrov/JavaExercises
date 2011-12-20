package com.clouway.designpatterns.storeobservation;

import java.util.Hashtable;
import java.util.Map;

/**
 * Handle the sold products from the shop
 * Created by Krasimir Dimitrov
 * Date: 12/19/11
 * Time: 12:57 PM
 */
public class SoldProducts implements ObserverForSoldProducts {
    public Map<String, Integer> soldProductsList;

    public SoldProducts(Map<String, Integer> list) {
        soldProductsList = new Hashtable<String, Integer>();
    }

    /**
     * update the list of sold products when a product sells
     * @param name the name of the product that we are selling
     * @param quantity the quantity of the product that we are selling
     */
    public void update(String name, Integer quantity) {
        if (soldProductsList.containsKey(name)) {
            soldProductsList.put(name, soldProductsList.get(name) + quantity);
        } else {
            soldProductsList.put(name, quantity);
        }
    }
}
