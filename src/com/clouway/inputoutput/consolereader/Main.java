package com.clouway.inputoutput.consolereader;

import java.util.InputMismatchException;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/30/11
 * Time: 3:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args){
        ConsoleReader consoleRead1= new ConsoleReader();
        char readValue;
        //readValue = consoleRead1.readChar();
       // System.out.println(readValue);
        try{
        consoleRead1.readInt();
        } catch (InputMismatchException e){
            System.err.println("You have entered an incorrect data type");
        }
        // ConsoleReader.readString();
        //ConsoleReader.readFloat();
    }
}
