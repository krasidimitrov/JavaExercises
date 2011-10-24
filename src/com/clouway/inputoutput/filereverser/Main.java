package com.clouway.inputoutput.filereverser;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 10/5/11
 * Time: 12:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args){


        FileContentReverser fcr = new FileContentReverser();
        try{
        fcr.readFile("/home/clouway/tester2.txt");
        } catch (FileNotFoundException e){
            System.err.println("Избрали сте несъществуващ файл. Моля проверете пътя до файла който сте избрали.");
        } catch (IOException e){
            System.err.println("I/O exception "+ e.getMessage());
        }
    }
}
