package com.clouway.testing.shop2;

import java.util.Hashtable;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 10/31/11
 * Time: 1:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class Product implements Comparable<Product> {


    private String name;
    private double price;
    private int quantity;
    private int maxQuantity;


    public Product(String productName, double productPrice, int productQuantity, int productMaxQuantity) {
        if (productQuantity > productMaxQuantity) {
            throw new QuantityBiggerThanMaxQuantityException();
        } else {
            name = productName;
            price = productPrice;
            quantity = productQuantity;
            maxQuantity = productMaxQuantity;
        }
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }


    public int compareTo(Product product) {
        if (this.price > product.price)
            return 1;
        else if (this.price < product.price)
            return -1;
        else return 0;

    }
}

