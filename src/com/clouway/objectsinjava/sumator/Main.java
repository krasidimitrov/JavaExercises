package com.clouway.objectsinjava.sumator;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/19/11
 * Time: 9:22 AM
 * To change this template use File | Settings | File Templates.
 */
class Main {
    public static void main(String[] args) {
        Sumator s = new Sumator();
        String a = "14.3";
        String b = "10";
        BigInteger ai = BigInteger.valueOf(10);
        BigInteger bi = BigInteger.valueOf(15);

        System.out.println(s.sum(a, b));
        System.out.println(s.sum(23.5, 17.9));
        System.out.println(s.sum(12, 23));
        System.out.println(s.sum(ai, bi));
        System.out.println(s.sum(BigDecimal.valueOf(13.2), BigDecimal.valueOf(11.1)));
    }
}
