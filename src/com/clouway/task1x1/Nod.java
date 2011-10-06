package com.clouway.task1x1;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/16/11
 * Time: 10:04 AM
 * To change this template use File | Settings | File Templates.
 */
class Nod {

    /**
     * find the GCD of two integer numbers
     * @param a first of the two numbers on which we will find the GCD
     * @param b second of the two numbers on which we will find the GCD
     */
    public static int findNod(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

}
