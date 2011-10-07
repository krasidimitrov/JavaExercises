package com.clouway.exceptions.stringsumator;


/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/19/11
 * Time: 9:19 AM
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
        sum = Double.parseDouble(a) + Double.parseDouble(b);
        return Double.toString(sum);
    }

}
