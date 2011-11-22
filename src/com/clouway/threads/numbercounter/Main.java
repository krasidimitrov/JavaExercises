package com.clouway.threads.numbercounter;

import java.util.Scanner;

/**
 * Created by Krasimir Dimitrov
 */

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String checker;

        NumberCounter counter = new NumberCounter();

        Thread thread1 = new Thread(new CountingThread(counter));

        thread1.start();
        checker = in.nextLine();
        if ((checker.equals("stop"))) {
            thread1.interrupt();
            System.out.println("Counter at value: " + counter.getCount());
        }
    }
}
