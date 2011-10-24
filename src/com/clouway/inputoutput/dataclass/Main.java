package com.clouway.inputoutput.dataclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 10/6/11
 * Time: 7:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {

        Hero hero1 = new Hero("Lilith", 25, 30.5);
        Hero newHero = null;
        DataClass dataClass = new DataClass();

        try {

            FileInputStream fis = new FileInputStream("/home/clouway/serial");
            FileOutputStream fos = new FileOutputStream("/home/clouway/serial");
            dataClass.saveObject(fos, hero1);
            newHero = (Hero) dataClass.getObject(fis);
        } catch (IOException e) {
            System.err.println("No such file");
        } catch (ClassNotFoundException e){
            System.err.println("No such class");
        }

        System.out.print(newHero.getName());


    }
}
