package com.clouway.designpatterns.proxy;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/19/11
 * Time: 12:06 PM
 */
public class Bank implements IBank {
    private int bankMoney = 10000;

    public Bank() {

    }

    public int drawMoney(int money) {
        bankMoney -= money;
        return money;
    }
}
