package com.clouway.introducingjava.gcd;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/17/11
 * Time: 5:03 PM
 * To change this template use File | Settings | File Templates.
 */
class Main {

    public static void main(String[] args) {
        Gcd newGcd = new Gcd();
        int result;
        result = newGcd.findGcd(150, 375);
        System.out.print(result);

    }
}
