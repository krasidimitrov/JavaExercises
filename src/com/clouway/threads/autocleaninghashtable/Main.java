package com.clouway.threads.autocleaninghashtable;

import java.util.Scanner;

/**
 * Created by Krasimir Dimitorv.
 */
public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);


        AutocleaningTable autocleaningTable = new AutocleaningTable();
        autocleaningTable.put("one", 1);
        autocleaningTable.put("two", "second");

        String checker;
        while (!(checker = in.next()).equals("quit")) {
            System.out.println(autocleaningTable.get(checker));
        }
    }
}
