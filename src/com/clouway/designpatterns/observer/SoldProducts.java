package com.clouway.designpatterns.observer;

import java.util.Map;

/**
 * Managing the sold products in the store
 * Created by Krasimir Dimitrov
 * Date: 12/26/11
 * Time: 5:59 PM
 */
public class SoldProducts implements SoldProductsListener {
    private Map<String, Integer> soldProductsList;

    /**
     * Constructor with one parameter
     *
     * @param list the list in which we are going to save all products sold from the store
     */
    public SoldProducts(Map<String, Integer> list) {
        soldProductsList = list;
    }

    /**
     * update the list of sold products when a product is sold
     *
     * @param name         the name of the product
     * @param quantitySold the quantity sold
     */
    public void onProductSell(String name, int quantitySold) {
        if (!soldProductsList.containsKey("Milka")) {
            soldProductsList.put(name, quantitySold);
        } else {
            soldProductsList.put(name, soldProductsList.get(name) + quantitySold);
        }
    }
}
