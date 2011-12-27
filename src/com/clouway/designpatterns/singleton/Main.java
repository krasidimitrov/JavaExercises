package com.clouway.designpatterns.singleton;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/13/11
 * Time: 3:38 PM
 */
public class Main {

    public static void main(String[] args) {
        ServerHistory history1 = ServerHistory.createInstance();
        ServerHistory history2 = ServerHistory.createInstance();
        if (history1.equals(history2))
            System.out.println("Success!");
    }
}