package com.clouway.inputoutput.textwritter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 10/5/11
 * Time: 10:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] arg){
//        TextWritter fileWriter = new TextWritter();
//        fileWriter.writeInFile();

        try {
            Scanner scaner = new Scanner(System.in);
            String fileName = scaner.nextLine();

            FileOutputStream fout = new FileOutputStream(new File(fileName));
            fout.write("tset".getBytes());
            fout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
