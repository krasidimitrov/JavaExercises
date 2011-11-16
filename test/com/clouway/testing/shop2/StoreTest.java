package com.clouway.testing.shop2;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 10/31/11
 * Time: 1:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class StoreTest {
    private Store store;
  //  private Hashtable<String, Product> productList = new Hashtable<String, Product>();
     Product kitkat ;

    @Before
    public void createTestableData() {
        store = new Store();//productList);
        kitkat = new Product("Kitkat", 0.84, 100, 300);
        store.addNewProduct(kitkat);
    }

    @Test
    public void addNewProductShouldAddNewProductToTheStorage() {
        assertTrue(store.getProductList().containsKey("Kitkat"));
    }

    @Test(expected = ProductAlreadyExistException.class)
    public void addNewProductShouldThrowExceptionIfWeTryToAddExistingProduct() {
//         Product kitkat = new Product("Kitkat", 0.84, 100, 300);
//        store.addNewProduct(kitkat);
        store.addNewProduct(kitkat);
    }

    @Test
    public void addQuantityShouldIncreaseTheQuantityOfExistingProduct() {
        store.addQuantity("Kitkat", 100);
        assertEquals(200, store.getProductList().get("Kitkat").getQuantity());
    }

    @Test(expected = ProductMaxQuantityExceededException.class)
    public void addQuantityShouldThrowExceptionIfTheMaxQuantityIsExceeded() {
        store.addQuantity("Kitkat", 300);
    }

    @Test(expected = ProductDoesNotExistException.class)
    public void addQuantityShouldThrowExceptionIfWeAddQuantityToNonExistingProduct() {
        store.addQuantity("Milka", 100);
    }

    @Test
    public void sellProductShouldDecreaseTheQuantityOfExistingProductAndReturnProfit() {
        double profit = store.sellProduct("Kitkat", 60);
        System.out.println(profit);
        assertEquals(40, store.getProductList().get("Kitkat").getQuantity());
        assertEquals(50.4, profit, 0.0);
    }

    @Test(expected = ProductQuantityInsufficientException.class)
    public void sellProductShouldThrowExceptionIfQuantityIsNotEnoughForSell() {
        store.sellProduct("Kitkat", 150);
    }

    @Test(expected = ProductDoesNotExistException.class)
    public void sellProductShouldThrowExceptionIfWeTryToSellNonExistingProduct() {
        store.sellProduct("Milka", 111);
    }

   @Test
   public void sortProductsByPriceShouldReturnSortedList() {
//        store.addNewProduct("Milka", 1.30, 100, 300);
//        store.addNewProduct("Mura", 3.84, 100, 300);
//        store.addNewProduct("Chio Chips", 2.50, 100, 300);
//        double[] result = new double[4];
//        double[] expected = {0.84, 1.30, 2.50, 3.84};
//        for (int i = 0; i < 4; i++) {
//            result[i] = store.sortProductsByPrice().get(i).getPrice();
//        }
//        for (int i = 0; i < 4; i++) {
//            assertEquals(expected[i], result[i], 0.0);
//        }

       Product prod2 = new Product("Milka", 1.30, 100, 300);
       Product prod3 = new Product("Mura", 3.84, 100, 300);
       Product prod4 = new Product("Chio Chips", 2.50, 100, 300);

       store.addNewProduct(prod2);
       store.addNewProduct(prod3);
       store.addNewProduct(prod4);

       List<Product> sortedProductList = store.sortProductsByPrice();
       assertEquals(kitkat, sortedProductList.get(0));
       assertEquals(prod2, sortedProductList.get(1));
       assertEquals(prod4, sortedProductList.get(2));
       assertEquals(prod3, sortedProductList.get(3));
   }


}
