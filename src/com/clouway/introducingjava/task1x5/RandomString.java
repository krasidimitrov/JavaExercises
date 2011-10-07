package com.clouway.task1x5;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/16/11
 * Time: 2:41 PM
 * To change this template use File | Settings | File Templates.
 */

public class RandomString {
    /**
     * generate a random string with fixed length
     *
     * @param len the length of the string that we want to generate
     */

    public String generateRandomString(int len) {
        Random gen = new Random();
        int num;
        String baseString = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ +-/=.!?@#$%^&*()_";
        String randomString = "";

        for (int i = 0; i < len; i++) {
            num = gen.nextInt(baseString.length());
            randomString = randomString + baseString.charAt(num);
        }

        return randomString;
    }
}
