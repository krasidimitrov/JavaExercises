package com.clouway.designpatterns.storeobservation;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/19/11
 * Time: 5:11 PM
 */
public class Main {

    public static void main(String[] args) {
        Map<String, Integer> listOfSoldProducts = new Hashtable<String, Integer>();
        Map<String, Integer> listOfAvailableProducts = new Hashtable<String, Integer>();

        SoldProducts soldProducts = new SoldProducts(listOfSoldProducts);
        AvailableProducts availableProducts = new AvailableProducts(listOfAvailableProducts);

        Shop lidl = new Shop();
        lidl.addObserverForAvailableProducts(availableProducts);
        lidl.addObserverForSoldProducts(soldProducts);

        lidl.addProduct("milka", 10);
        lidl.sellProduct("milka", 20);

    }
}
