package com.clouway.objectsinjava.sumator;


import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/19/11
 * Time: 9:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class Sumator {

    /**
     * calculate the sum of two Integers
     *
     * @param a the first Integer from the two we are going to add
     * @param b the second Integer from the two we are going to add
     * @return the sum of the two integers
     */
    public Integer sum(Integer a, Integer b) {
        return a + b;
    }

    /**
     * calculate the sum of two Doubles
     *
     * @param a the first Double from the two we are going to add
     * @param b the second Double from the two we are going to add
     * @return the sum of the two Doubles
     */
    public Double sum(Double a, Double b) {
        return a + b;
    }

    /**
     * calculate the sum of two Strings numbers
     *
     * @param a the first String(number) from the two we are going to add
     * @param b the second String(number) from the two we are going to add
     * @return the sum of the two Strings
     */
    public String sum(String a, String b) {
        double c;
        c = Double.parseDouble(a) + Double.parseDouble(b);
        return Double.toString(c);
    }

    /**
     * calculate the sum of two BigIntegers
     *
     * @param a the first BigInteger from the two we are going to add
     * @param b the second BigInteger from the two we are going to add
     * @return the sum of the two BigIntegers
     */
    public BigInteger sum(BigInteger a, BigInteger b) {
        return a.add(b);
    }

    /**
     * calculate the sum of two BigDecimal
     *
     * @param a the first BigDecimal from the two we are going to add
     * @param b the second BigDecimal from the two we are going to add
     * @return the sum of the two BigDecimals
     */
    public BigDecimal sum(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

}
