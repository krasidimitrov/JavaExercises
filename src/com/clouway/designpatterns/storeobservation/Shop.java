package com.clouway.designpatterns.storeobservation;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/19/11
 * Time: 3:32 PM
 */
public class Shop {
    private ObserverForSoldProducts soldProducts;
    private ObserverForAvailableProducts availableProducts;

    public void addObserverForSoldProducts(ObserverForSoldProducts observer) {
        soldProducts = observer;
    }

    public void addObserverForAvailableProducts(ObserverForAvailableProducts observer) {
        availableProducts = observer;
    }

    public void addProduct(String name, Integer quantity) {
        availableProducts.updateOnProductAdd(name, quantity);
    }

    public void sellProduct(String name, Integer quantity) {
        availableProducts.updateOnProductSell(name, quantity);
        soldProducts.update(name, quantity);
    }

}
