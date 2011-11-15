package com.clouway.testing.shop2;


import org.junit.Before;
import org.junit.Test;

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
        storage.addNewProduct("Kitkat", 0.84, 100, 300);
    }

    @Test
    public void addNewProductShouldAddNewProductToTheStorage() {
        assertTrue(productList.containsKey("Kitkat"));
    }

    @Test(expected = ProductAlreadyExistException.class)
    public void addNewProductShouldThrowExceptionIfWeTryToAddExistingProduct() {
        storage.addNewProduct("Kitkat", 0.84, 100, 300);
    }

    @Test
    public void addQuantityShouldIncreaseTheQuantityOfExistingProduct() {
        storage.addQuantity("Kitkat", 100);
        assertEquals(200, productList.get("Kitkat").getQuantity());
    }

    @Test(expected = ProductMaxQuantityExceededException.class)
    public void addQuantityShouldThrowExceptionIfTheMaxQuantityIsExceeded() {
        storage.addQuantity("Kitkat", 300);
    }

    @Test(expected = ProductDoesNotExistException.class)
    public void addQuantityShouldThrowExceptionIfWeAddQuantityToNonExistingProduct() {
        storage.addQuantity("Milka", 100);
    }

    @Test
    public void sellProductShouldDecreaseTheQuantityOfExistingProduct() {
        storage.sellProduct("Kitkat", 60);
        assertEquals(40, productList.get("Kitkat").getQuantity());
    }

    @Test(expected = ProductQuantityInsufficientException.class)
    public void sellProductShouldThrowExceptionIfQuantityIsNotEnoughForSell() {
        storage.sellProduct("Kitkat", 150);
    }

    @Test(expected = ProductDoesNotExistException.class)
    public void sellProductShouldThrowExceptionIfWeTryToSellNonExistingProduct() {
        storage.sellProduct("Milka", 111);
    }

    @Test
    public void sortProductsByPriceShouldReturnSortedList() {
       // storage.addNewProduct("Kitkat", 0.84, 100, 300);
        storage.addNewProduct("Milka", 1.30, 100, 300);
        storage.addNewProduct("Mura", 3.84, 100, 300);
        storage.addNewProduct("Chio Chips", 2.50, 100, 300);
        double[] result = new double[4];
        double[] expected = {0.84, 1.30, 2.50, 3.84};
        for (int i = 0; i < 4; i++) {
            result[i] = storage.sortProductsByPrice().get(i).getPrice();
        }
        for (int i = 0; i < 4; i++) {
            assertEquals(expected[i], result[i], 0.0);
        }

    }
}
