package com.clouway.designpatterns.proxy;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/19/11
 * Time: 12:17 PM
 */
public class Main {
    public static void main(String[] args) {

        Alianz allianz = new Alianz();
        ATM alliazATM = new ATM(allianz);
        alliazATM.withdraw(300);
        alliazATM.withdraw(1999);
    }
}
