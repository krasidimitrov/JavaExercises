package com.clouway.designpatterns.tddobserver;

import java.util.ArrayList;

/**
 * Managing the available products in the store
 * Created by Krasimir Dimitrov
 * Date: 12/26/11
 * Time: 4:51 PM
 */
public class AvailableProducts implements AvailableProductsListener {

    private ArrayList<Product> availableProductsList;

    /**
     * Constructor with one parameter
     * @param arrayList the list in which we are going to save all products that are added to the store
     */
    public AvailableProducts(ArrayList<Product> arrayList) {
        availableProductsList = arrayList;
    }

    /**
     * Add product to the list of available products
     * @param product the product that we are going to add
     */
    public void onNewProductAdd(Product product) {
        availableProductsList.add(product);
    }
}
