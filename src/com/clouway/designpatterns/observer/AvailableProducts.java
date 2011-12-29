package com.clouway.designpatterns.observer;

import java.util.List;

/**
 * Managing the available products in the store
 * Created by Krasimir Dimitrov
 * Date: 12/26/11
 * Time: 4:51 PM
 */
public class AvailableProducts implements AvailableProductsListener {

    private List<String> availableProductsList;

    /**
     * Constructor with one parameter
     * @param list the list in which we are going to save all products that are added to the store
     */
    public AvailableProducts(List<String> list) {
        availableProductsList = list;
    }

    /**
     * Add product to the list of available products
     * @param productName the product that we are going to add
     */
    public void onNewProductAdd(String productName) {
        availableProductsList.add(productName);
    }
}
