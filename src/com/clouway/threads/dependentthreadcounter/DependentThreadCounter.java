package com.clouway.threads.dependentthreadcounter;

/**
 * Used for creating two runnable objects that count and when one of them reach their maximum count they both stop
 * Created by IntelliJ IDEA.
 */

public class DependentThreadCounter implements Runnable {

    private int count;
    private Thread referenceThread;

    /**
     * Construct an instance of DependentThreadCounter
     *
     * @param count
     */
    public DependentThreadCounter(int count) {
        this.count = count;
    }

    public void run() {
        int i = 0;
        while (i < count) {
            i++;
            System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                return;
            }
        }
        Thread.currentThread().interrupt();
        referenceThread.interrupt();
    }

    public void setReference(Thread thread) {
        referenceThread = thread;
    }
}
