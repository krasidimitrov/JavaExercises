package com.clouway.testing.stringsumator;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 10/24/11
 * Time: 10:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class Sumator {

    /**
     * calculate the sum of two Strings numbers
     *
     * @param a the first String(number) from the two we are going to add
     * @param b the second String(number) from the two we are going to add
     * @return the sum of the two Strings
     */
    public String sum(String a, String b) {
        double sum;
        if (a == null || b == null) {
            throw new IllegalArgumentException();
        }
        sum = Double.parseDouble(a) + Double.parseDouble(b);
        return Double.toString(sum);
    }

}

