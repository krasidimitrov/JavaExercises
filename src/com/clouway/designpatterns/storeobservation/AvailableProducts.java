package com.clouway.designpatterns.storeobservation;

import java.util.Hashtable;
import java.util.Map;

/**
 * Handle the available products in the Shop
 * Created by Krasimir Dimitrov
 * Date: 12/19/11
 * Time: 12:58 PM
 */
public class AvailableProducts implements ObserverForAvailableProducts {

    public Map<String, Integer> availableProductsList;

    public AvailableProducts(Map<String, Integer> list) {
        availableProductsList = new Hashtable<String, Integer>();
    }

    /**
     * update the list of products on product add
     * @param name the name of the product that we add
     * @param quantity  the quantity of the product that we add
     */
    public void updateOnProductAdd(String name, Integer quantity) {
        if (availableProductsList.containsKey(name)) {
            availableProductsList.put(name, availableProductsList.get(name) + quantity);
        } else {
            availableProductsList.put(name, quantity);
        }
    }

    /**
     * update the list of available products on product sell
     * @param name the name of the product that we are selling
     * @param quantity the qunatity of the product that we are selling
     */
    public void updateOnProductSell(String name, Integer quantity) {
        int quantityAfterSell = availableProductsList.get(name) - quantity;
        if (quantityAfterSell >= 0) {
            availableProductsList.put(name, quantity);
        } else {
            throw new QuantityNotEnoughForSellException();
        }
    }
}
