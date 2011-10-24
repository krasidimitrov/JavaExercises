package com.clouway.inputoutput.textwritter;

import java.io.*;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 10/5/11
 * Time: 10:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class TextWritter {

    Scanner input = new Scanner(System.in);
    public String fileName;


    /**
     * write in a file from the console until you enter 'quit'
     */
    public void writeInFile() {
        BufferedWriter bufWriter = null;
        System.out.println("Write in file until you enter 'quit'");
        try {
            bufWriter= new BufferedWriter(new FileWriter(fileName));

            while(!input.hasNext("quit")) {
                bufWriter.write(input.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
