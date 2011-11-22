package com.clouway.threads.dependentsynchronizedcounter;

/**
 * Created by IntelliJ IDEA.
 * User: 12345
 * Date: 11/21/11
 * Time: 9:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {

    SharedCounter sharedCounter = new SharedCounter();

    Thread thread1 = new Thread(new SharedCounterUsingThread(20,sharedCounter));
    Thread thread2 = new Thread(new SharedCounterUsingThread(20,sharedCounter));

        thread1.start();
        thread2.start();

    }
}
