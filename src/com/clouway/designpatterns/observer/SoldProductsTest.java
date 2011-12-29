package com.clouway.designpatterns.observer;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/28/11
 * Time: 6:39 PM
 */
public class SoldProductsTest {
    private Map<String, Integer> soldProductsList;
    private SoldProductsListener soldProductsListener;

    @Before
    public void createTestableData(){
        soldProductsList = new Hashtable<String, Integer>();
        soldProductsListener = new SoldProducts(soldProductsList);
        soldProductsListener.onProductSell("Milka",100);
    }

    @Test
    public void shouldAddNewProductToTheSoldProductsListOnProductSell(){
        assertEquals(new Integer(100), soldProductsList.get("Milka"));
    }

    @Test
    public void shouldIncreaseTheQuantityOfAnExistingProductOnProductSell(){
        soldProductsListener.onProductSell("Milka",50);
        assertEquals(new Integer(150),soldProductsList.get("Milka"));
    }
}
