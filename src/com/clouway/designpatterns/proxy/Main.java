package com.clouway.designpatterns.proxy;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/19/11
 * Time: 12:17 PM
 */
public class Main {
    public static void main(String[] args) {

        Bank allianz = new Bank();
        ATM alliazATM = new ATM(allianz);
        alliazATM.drawMoney(300);
        alliazATM.drawMoney(1999);
    }
}
