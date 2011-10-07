package com.clouway.exceptions.numberreader;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/28/11
 * Time: 2:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] arg) {
        ConsoleInput consoeInput1 = new ConsoleInput();
            while(true){
                try {
                    consoeInput1.inputNumbers();
                    break;
                } catch (RangeException e) {
                   System.err.println("You have entered an invalid number");

                }
            }
    }
}
