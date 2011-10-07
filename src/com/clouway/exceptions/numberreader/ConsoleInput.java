package com.clouway.exceptions.numberreader;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/28/11
 * Time: 2:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConsoleInput {

    /**
     * allow the user to input numbers from the console
     */
    public void inputNumbers() throws RangeException {
        Scanner in = new Scanner(System.in);
        int number;
            number = in.nextInt();
            if (number < 0 || number > 100) {
                throw new RangeException();
            }

    }


}
