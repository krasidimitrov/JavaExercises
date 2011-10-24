package com.clouway.inputoutput.consolereader;


import com.sun.corba.se.impl.io.TypeMismatchException;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/30/11
 * Time: 3:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConsoleReader {
    public Scanner in = new Scanner(System.in);

    /**
     * read a string from the console
     *
     * @return the read string
     */
    public String readString() {
        return in.next();
    }

    /**
     * read an integer number from the console
     *
     * @return the read integer number
     */
    public int readInt() throws InputMismatchException {
        return in.nextInt();
    }

    /**
     * read a char from the console
     *
     * @return the read char
     */
    public char readChar() {

        return in.next().charAt(0);
    }

    /**
     * read a float number from the console
     *
     * @return the read float number
     */
    public float readFloat() throws InputMismatchException {
        return in.nextFloat();
    }

}
