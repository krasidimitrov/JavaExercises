package com.clouway.jdbc.usershistory.userstabledatagenerator;

import java.io.*;
import java.util.Random;

/**
 * Write raw data into text file for the table Users
 * Created by Krasimir Dimitrov
 * Date: 1/3/12
 * Time: 2:47 PM
 */
public class RawDataGenerator {

    public String fileName;
    Random rand = new Random();


    /**
     * write in a file from the console until you enter 'quit'
     */
    public void writeInFile() {
        String[] names = {"Krasi","Ivan","Adio","Miro","Misho","Georgi","Kami","Rosen","Lili","Sasho"};
        String[] emails = {"555@mail.bg","222@mail.bg","aaa@abv.bg","bbb@abv.bg","abb@abv.bg"};
        String[] city = {"Chicago","Miami","Beijing","Toronto","Rio"};
        int[] salary = {600,1000,1400,1800,2200,2600,3000,3400,3800,4200};
        BufferedWriter bufWriter = null;
        System.out.println("Write in file until you enter 'quit'");
        try {
            bufWriter= new BufferedWriter(new FileWriter("/home/clouway/Desktop/test"));
            int i=0;
            while(i<1000000) {
                bufWriter.write("\\N"+","+names[rand.nextInt(10)]+","+salary[rand.nextInt(10)]+","+emails[rand.nextInt(5)]+","+city[rand.nextInt(5)]+"\n");
                i++;
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

    public static void main(String[] args) {
        RawDataGenerator textWritter = new RawDataGenerator();
        textWritter.writeInFile();
    }
}
