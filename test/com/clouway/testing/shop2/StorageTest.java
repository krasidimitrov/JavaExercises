package com.clouway.testing.shop2;


import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.*;
import java.util.Hashtable;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 10/31/11
 * Time: 1:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class StorageTest {
    private Storage storage;
    private Hashtable<String, Product> productList = new Hashtable<String, Product>();

    @Before
    public void createTestableData() {
        storage = new Storage(productList);
    }

    @Test
    public void addProductShouldAddNewProductToTheStorage() {
        storage.addProduct("Kitkat", 0.84, 100, 300);
        //Product expected = new Product("K", 0.84, 100, 300);
        assertTrue(productList.containsKey("Kitkat"));
    }

    @Test(expected = ProductAlreadyExistException.class)
    public void addProductShouldThrowException() {
        storage.addProduct("Kitkat", 0.84, 100, 300);
        storage.addProduct("Kitkat", 0.84, 100, 300);
    }

    @Test
    public void addQuantityShouldIncreaseTheQuantityOfExistingProduct() {
        storage.addProduct("Kitkat", 0.84, 100, 300);
        storage.addQuantity("Kitkat", 100);
        assertEquals(200, productList.get("Kitkat").getQuantity());
    }

    @Test(expected = ProductMaxQuantityExceededException.class)
    public void addQuantityShouldThrowExceptionIfTheMaxQuantityIsExceeded() {
        storage.addProduct("Kitkat", 0.84, 100, 200);
        storage.addQuantity("Kitkat", 300);
    }

    @Test(expected = ProductDoesNotExistException.class)
    public void addQuantityShouldThrowExceptionIfWeAddQuantityToNonExistingProduct() {
        storage.addQuantity("Kitkat", 100);
    }

    @Test
    public void sellProductShouldDecreaseTheQuantityOfExistingProduct() {
        storage.addProduct("Kitkat", 0.84, 100, 300);
        storage.sellProduct("Kitkat", 60);
        assertEquals(40, productList.get("Kitkat").getQuantity());
    }

    @Test(expected = ProductQuantityInsufficientException.class)
    public void sellProductShouldThrowExceptionIfQuantityIsNotEnoughForSell() {
        storage.addProduct("Kitkat", 0.84, 100, 300);
        storage.sellProduct("Kitkat", 150);
    }

    @Test(expected = ProductDoesNotExistException.class)
    public void sellProductShouldThrowExceptionIfWeTryToSellNonExistingProduct() {
        storage.sellProduct("Kitkat", 111);
    }

    @Test
    public void sortByPriceShouldReturnSortedList() {
        storage.addProduct("Kitkat", 3.84, 100, 300);
        storage.addProduct("Milka", 1.30, 100, 300);
        storage.addProduct("Mura", 0.84, 100, 300);
        storage.addProduct("Chio Chips", 2.50, 100, 300);
        double[] result = new double[4];
        double[] expected = {0.84, 1.30, 2.50, 3.84};
        for (int i = 0; i < 4; i++) {
            result[i] = storage.sortByPrice().get(i).getPrice();
        }
        for (int i = 0; i < 4; i++) {
            assertEquals(expected[i], result[i], 0.0);
        }

    }
}
