package com.clouway.threads.numbercounter;

/**
 * create a runnable object that increase his counter by 1 on some time interval
 * Created by Krasimir Dimitrov
 */

public class CountingThread implements Runnable {
    private NumberCounter counter;

    public CountingThread(NumberCounter counter) {
        this.counter = counter;
    }

    public void run() {
        while (true) {
            counter.increaseCount();
            System.out.println(counter.getCount());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

}
