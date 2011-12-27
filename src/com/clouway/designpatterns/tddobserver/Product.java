package com.clouway.designpatterns.tddobserver;

/**
 * Product class for the products in the store
 * Created by Krasimir Dimitrov
 * Date: 12/26/11
 * Time: 4:41 PM
 */
public class Product {
    private String name;
    private int quantity;

    public Product(String name,int quantity){
        this.name = name;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
