package com.clouway.designpatterns.storeobservation;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/19/11
 * Time: 12:58 PM
 */
public class AvailableProducts implements ObserverForAvailableProducts {

    public Map<String, Integer> availableProductsList;

    public AvailableProducts(Map<String, Integer> list) {
        availableProductsList = new Hashtable<String, Integer>();
    }

    public void updateOnProductAdd(String name, Integer quantity) {
        if (availableProductsList.containsKey(name)) {
            availableProductsList.put(name, availableProductsList.get(name) + quantity);
        } else {
            availableProductsList.put(name, quantity);
        }
    }

    public void updateOnProductSell(String name, Integer quantity) {
        int quantityAfterSell = availableProductsList.get(name) - quantity;
        if (quantityAfterSell >= 0) {
            availableProductsList.put(name, quantity);
        } else {
            throw new QuantityNotEnoughForSellException();
        }
    }
}
