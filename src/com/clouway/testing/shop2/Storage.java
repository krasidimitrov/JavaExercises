package com.clouway.testing.shop2;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import static java.util.Collections.sort;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 10/31/11
 * Time: 1:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Storage {
    private Hashtable<String, Product> productList;// = new Hashtable<String, Product>();


    public Storage(Hashtable<String, Product> productList){
        this.productList = productList;
    }

    /**
     * add a new product to the storage
     * @param productName the name of the product that we add
     * @param productPrice  the price of the product that we add
     * @param productQuantity  the quantity of the product that we add
     * @param productMaxQuantity  the max quantity of the product that we add
     */
    public void addNewProduct(String productName, double productPrice, int productQuantity, int productMaxQuantity) {
        if (productList.containsKey(productName)) {
            throw new ProductAlreadyExistException();
        } else {
            Product product = new Product(productName, productPrice, productQuantity, productMaxQuantity);
            productList.put(product.getName(), product);
        }
    }

    /**
     * increase the quantity of an existing product
     * @param productName the name of the product of which we want to increase quantity
     * @param productQuantity  the quantity that we want to add
     */
    public void addQuantity(String productName, int productQuantity) {
        if (productList.containsKey(productName) && getProductQuantity(productName) + productQuantity <= productList.get(productName).getMaxQuantity()) {
            productList.get(productName).setQuantity(getProductQuantity(productName) + productQuantity);
        } else if (!productList.containsKey(productName)) {
            throw new ProductDoesNotExistException();
        } else {
            throw new ProductMaxQuantityExceededException();
        }

    }

    /**
     * decrease the quantity of an existing product
     * @param productName the name of the product that we want to sell
     * @param productQuantity  the quantity  that we want to sell from this product
     */
    public void sellProduct(String productName, int productQuantity) {
        if (productList.containsKey(productName) && getProductQuantity(productName) - productQuantity >= 0) {
            productList.get(productName).setQuantity(getProductQuantity(productName) - productQuantity);
        } else if (!productList.containsKey(productName)) {
            throw new ProductDoesNotExistException();
        } else {
            throw new ProductQuantityInsufficientException();
        }
    }

    private int getProductQuantity(String productName) {
        return productList.get(productName).getQuantity();
    }

    /**
     * put all products in a list and sort them  by price
     * @return  the sorted list
     */
    public List<Product> sortProductsByPrice() {
        List<Product> list = new LinkedList<Product>();
        Enumeration e = productList.elements();
        while (e.hasMoreElements()) {
            list.add((Product) e.nextElement());
        }
        sort(list);
        return list;

//        for (int i =0; i<list.size(); i++)
//             System.out.println(list.get(i).name + " " + list.get(i).price);
    }

}
