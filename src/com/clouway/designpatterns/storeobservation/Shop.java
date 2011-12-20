package com.clouway.designpatterns.storeobservation;

/**
 *For managing a shop
 * Created by Krasimir Dimitrov
 * Date: 12/19/11
 * Time: 3:32 PM
 */
public class Shop {
    private ObserverForSoldProducts soldProducts;
    private ObserverForAvailableProducts availableProducts;

    /**
     * add observer for the SoldProduc.class
     * @param observer the observer that we add
     */
    public void addObserverForSoldProducts(ObserverForSoldProducts observer) {
        soldProducts = observer;
    }

    /**
     * add observer for the AvailableProducts.class
     * @param observer the observer that we add
     */
    public void addObserverForAvailableProducts(ObserverForAvailableProducts observer) {
        availableProducts = observer;
    }

    /**
     * add a product to the shop
     * @param name the name of the product that we add
     * @param quantity the quantity of the product that we add
     */
    public void addProduct(String name, Integer quantity) {
        availableProducts.updateOnProductAdd(name, quantity);
    }

    /**
     * sell a product from the shop
     * @param name the name of the product that we sell
     * @param quantity the quantity of the product that we seell
     */
    public void sellProduct(String name, Integer quantity) {
        availableProducts.updateOnProductSell(name, quantity);
        soldProducts.update(name, quantity);
    }

}
