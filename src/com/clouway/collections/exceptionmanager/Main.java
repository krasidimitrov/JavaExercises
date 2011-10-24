package com.clouway.collections.exceptionmanager;

import java.util.Hashtable;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 10/24/11
 * Time: 10:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

       public static void main(String[] args) {

        ExceptionMessageManager tester = new ExceptionMessageManager(new Hashtable<String, String>());

        try {
            tester.registerErrorMessage("das", "gsa");
            tester.registerErrorMessage("ex1", "dasda");
        } catch (KeyOfHashTableExistException e) {
            System.err.println("Key already exist. Choose another key.");

        } catch (ValueOfHashTableExistException e) {
            System.err.println("Value already exist. Choose another value/");
        }

        System.out.println(tester.getErrorMessages());
    }
}
