package com.clouway.threads.dependentsynchronizedcounter;

/**
 * Used for counting numbers
 * Created by Krasimir Dimitrov
 */

public class SharedCounter {

    /**
     * Increase the count + 1 until maxCount is reached
     *
     * @param maxCount the value to which the counter will count
     */
    public synchronized void count(int maxCount) {
        int count = 0;
        while (true) {
            try {
                count++;
                Thread.sleep(200);
                notify();
                System.out.println(Thread.currentThread().getName() + " " + count);
                if(count==maxCount){
                    Thread.currentThread().interrupt();
                }
                wait();
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
