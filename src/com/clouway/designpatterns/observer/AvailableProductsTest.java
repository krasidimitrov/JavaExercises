package com.clouway.designpatterns.observer;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/28/11
 * Time: 6:08 PM
 */
public class AvailableProductsTest {

    private AvailableProducts availableProducts;
    private List<String> availableProductsList;


    @Before
    public void createTestableData(){
        availableProductsList = new ArrayList<String>();
       availableProducts = new AvailableProducts(availableProductsList);
    }

    @Test
    public void shouldAddProductToTheAvailableProductsList(){
        availableProducts.onNewProductAdd("Milka");
        assertEquals("Milka",availableProductsList.get(0));

    }

}
