package com.clouway.designpatterns.observer;

import java.util.Hashtable;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/26/11
 * Time: 4:09 PM
 */
public class Store {

    private Hashtable<String, Product> productList = new Hashtable<String, Product>();
    private AvailableProductsListener availableProductsListener;
    private SoldProductsListener soldProductsListener;

    public void addListenerForAvailableProducts(AvailableProductsListener listener) {
        this.availableProductsListener = listener;
    }

    public void addListenerForSoldProducts(SoldProductsListener listener) {

        this.soldProductsListener = listener;
    }

    /**
     * register a product to the store
     *
     * @param product the product that we want to register
     */
    public void registerProduct(Product product) {
        if (product == null) {
            throw new NullProductException();
        }
        if (productList.containsKey(product.getName())) {
            throw new ProductAlreadyExistException();
        }
        productList.put(product.getName(), product);
        availableProductsListener.onNewProductAdd(product.getName());
    }

    /**
     * sell product from the store
     *
     * @param name         the name of the product that we want to sell
     * @param soldQuantity the quantity that we are selling
     */
    public void sellProduct(String name, int soldQuantity) {
        if (!productList.containsKey(name)) {
            throw new ProductDoesntExistException();
        } else if (productList.containsKey(name) && productList.get(name).getQuantity() - soldQuantity < 0) {
            throw new NotEnoughQuantityForSellException();
        } else {
            soldProductsListener.onProductSell(name, soldQuantity);
        }
    }

}
