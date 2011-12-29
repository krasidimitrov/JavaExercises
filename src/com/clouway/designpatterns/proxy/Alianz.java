package com.clouway.designpatterns.proxy;

/**
 * Alianz manager
 * Created by Krasimir Dimitrov
 * Date: 12/19/11
 * Time: 12:06 PM
 */
public class Alianz implements Bank {
    private int bankMoney = 10000;

    public Alianz() {

    }

    /**
     *Decrasing the balance in the bank and return the sum drawn
     * @param money  that we want to draw
     * @return money drawn
     */
    public int drawMoney(int money) {
        bankMoney -= money;
        return money;
    }
}
