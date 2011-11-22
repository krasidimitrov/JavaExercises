package com.clouway.threads.dependentsynchronizedcounter;

/**
 * For creating a runnable object that will use the SharedCounter.class
 * Created by Krasimir Dimitrov
 */

public class CountingThread implements Runnable {
    SharedCounter sharedCounter;
    int maxCount;

    /**
     * Construct a runnable object that use the SharedCOunter
     * @param maxCount  the limit of the counter
     * @param sharedCounter  the counter object that we are using
     */
    public CountingThread(int maxCount, SharedCounter sharedCounter) {
        this.maxCount = maxCount;
        this.sharedCounter = sharedCounter;
    }

    public void run() {

        sharedCounter.count(maxCount);
        Thread.currentThread().interrupt();
    }

}
