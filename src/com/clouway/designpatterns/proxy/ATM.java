package com.clouway.designpatterns.proxy;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/19/11
 * Time: 12:06 PM
 */
public class ATM implements IBank {

    private IBank bank;

    public ATM(IBank bank) {
        this.bank = bank;
    }

    public int drawMoney(int money) {
        if (money <= 500) {
            return bank.drawMoney(money);
        } else {
            System.out.println("You need to go to the bank for sum bigger than 500");
            throw new SumIsTooBigForTheATMException();
        }
    }
}
