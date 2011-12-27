package com.clouway.designpatterns.tddobserver;

import org.jmock.Mockery;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/26/11
 * Time: 2:59 PM
 */

@RunWith(JMock.class)
public class StoreTest {
    Store store;
    Mockery context = new JUnit4Mockery();
    AvailableProductsListener availableProductsListener;
    ArrayList<Product> availableProductsList;
    Hashtable<String,Integer> soldProductsList;
    SoldProductsListener soldProductsListener;
    Product product;

    @Before
    public void createTestableData() {
        store = new Store();
        availableProductsListener = context.mock(AvailableProductsListener.class);
        soldProductsListener = context.mock(SoldProductsListener.class);
        store.addListenerForSoldProducts(soldProductsListener);
        store.addListenerForAvailableProducts(availableProductsListener);
        product = new Product("Milka", 200);
    }

    @Test
    public void shouldNotifyTheAvailableProductListOnNewProductRegister() {

        context.checking(new Expectations() {{
            oneOf(availableProductsListener).onNewProductAdd(product);
        }});

        store.registerProduct(product);
    }

    @Test
    public void shouldUpdateSoldProductsListOnProductSell() {
        context.checking(new Expectations() {{
            oneOf(soldProductsListener).onProductSell("Milka",100);
        }});

        store.sellProduct("Milka",100);
    }

    @Test
    public void shouldAddProductToAvailableProductsList() {
        Store store2 = new Store();
        availableProductsList = new ArrayList<Product>();
        AvailableProductsListener availableProductsListener2 = new AvailableProducts(availableProductsList);
        store2.addListenerForAvailableProducts(availableProductsListener2);
        store2.registerProduct(product);
        assertEquals(product, availableProductsList.get(0));
    }

    @Test
    public void shouldAddProductToSoldProductsList() {
        Store store2 = new Store();
        soldProductsList = new Hashtable<String,Integer>();
        SoldProductsListener soldProductsListener2 = new SoldProducts(soldProductsList);
        store2.addListenerForSoldProducts(soldProductsListener2);
        store2.sellProduct("Milka", 100);
        assertEquals(new Integer(100), soldProductsList.get("Milka"));
    }
}
