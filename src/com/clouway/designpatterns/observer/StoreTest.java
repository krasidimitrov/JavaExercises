package com.clouway.designpatterns.observer;

import org.jmock.Mockery;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import java.util.Hashtable;
import java.util.List;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/26/11
 * Time: 2:59 PM
 */

@RunWith(JMock.class)
public class StoreTest {
    private Store store;
    Mockery context = new JUnit4Mockery();
    private AvailableProductsListener availableProductsListener;
    private List<Product> availableProductsList;
    private Hashtable<String, Integer> soldProductsList;
    private SoldProductsListener soldProductsListener;
    private Product product;

    @Before
    public void createTestableData() {
        store = new Store();
        availableProductsListener = context.mock(AvailableProductsListener.class);
        soldProductsListener = context.mock(SoldProductsListener.class);
        store.addListenerForSoldProducts(soldProductsListener);

        product = new Product("Milka", 200);
    }

    @Test
    public void shouldNotifyTheAvailableProductListOnNewProductRegister() {
        store.addListenerForAvailableProducts(availableProductsListener);

        context.checking(new Expectations() {{
            oneOf(availableProductsListener).onNewProductAdd(product.getName());
        }});

        store.registerProduct(product);
    }

    @Test
    public void shouldNotifyTheSoldProductListOnSellingProduct() {

        context.checking(new Expectations() {{
            oneOf(soldProductsListener).onProductSell("Milka", 100);

        }});

        store.registerProduct(product);
        store.sellProduct("Milka", 100);

    }

    @Test(expected = NullProductException.class)
    public void shouldThrowExceptionOnAddingNullProduct() {
        store.registerProduct(null);
    }

    @Test(expected = ProductAlreadyExistException.class)
    public void shouldThrowExceptionOnRegisteringExistingProductInTheStore() {
        store.registerProduct(product);
        store.registerProduct(product);
    }

    @Test(expected = ProductDoesntExistException.class)
    public void shouldThrowExceptionIfSellingNotExistingProduct() {
        store.sellProduct("Chio Chips", 100);
    }

    @Test(expected = NotEnoughQuantityForSellException.class)
    public void shouldThrowExceptionIfThereIsNoEnoughQuantityForSell() {

        store.registerProduct(product);
        store.sellProduct("Milka", 300);
    }
}