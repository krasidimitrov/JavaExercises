package com.clouway.designpatterns.proxy;

/**
 * ATM manager
 * Created by Krasimir Dimitrov
 * Date: 12/19/11
 * Time: 12:06 PM
 */
public class ATM implements WithdrawsMoney {

    private Bank bank;

    public ATM(Bank bank) {
        this.bank = bank;
    }

    /**
     * Decrease the balance in the bank and return the money drawn
     * @param money the money that we want to draw
     * @return  the money drawn
     */
    public int withdraw(int money) {
        if (money <= 500) {
            return bank.withdraw(money);
        } else {
            System.out.println("You need to go to the bank for sum bigger than 500");
            throw new SumIsTooBigForTheATMException();
        }
    }
}
