package com.clouway.threads.dependentthreadcounter;

/**
 * Created by Krasimir Dimitrov
 */

public class Main {

    public static void main(String[] args) {
        DependentThreadCounter counter1 = new DependentThreadCounter(5);
        DependentThreadCounter counter2 = new DependentThreadCounter(25);

        Thread thread1 = new Thread(counter1);
        Thread thread2 = new Thread(counter2);

        counter1.setReference(thread2);
        counter2.setReference(thread1);

        thread1.start();
        thread2.start();
    }
}
