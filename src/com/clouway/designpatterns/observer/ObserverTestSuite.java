package com.clouway.designpatterns.observer;

import junit.framework.TestResult;
import junit.framework.TestSuite;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/29/11
 * Time: 9:43 AM
 */
public class ObserverTestSuite {
    public static void main(String[] args) {

        Class[] testClasses = {StoreTest.class, AvailableProductsTest.class, SoldProductsTest.class};
        TestSuite suite = new TestSuite(testClasses);
        TestResult result= new TestResult();
        suite.run(result);
        System.out.println(result.errorCount());

    }
}
