package com.clouway.introducingjava.stringgenerator;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/17/11
 * Time: 5:38 PM
 * To change this template use File | Settings | File Templates.
 */
class Main {

    public static void main(String[] args) {
        RandomString rs = new RandomString();
        String result;
        result = rs.generateRandomString(10);
        System.out.print(result);
    }
}
