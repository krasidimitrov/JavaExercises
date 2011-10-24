package com.clouway.inputoutput.transferobject;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 10/6/11
 * Time: 3:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {

        int tranferedBytes = 0;
        TransferObject transferObj = new TransferObject();

        try {
           InputStream fis = new FileInputStream("/home/clouway/old.txt");
           OutputStream fos = new FileOutputStream("/home/clouway/new.txt");
            tranferedBytes = transferObj.transfer(fis, fos, 5, 2);

        } catch (FileNotFoundException e) {
            System.err.println("File does not exist! Please enter a valid file name.");
        }
        System.out.println(tranferedBytes);
    }
}
