package com.clouway.threads.autocleaninghashtable;

import java.util.Hashtable;

/**
 * For creating runnable object that follow the life cycle of a key
 * Created by Krasimir Dimitrov
 */

public class LifecycleThread implements Runnable {
    private int timeCounter = 0;
    private String key;
    private Hashtable<String, Object> valuesStorage;
    private Hashtable<String, LifecycleThread> threadReferencesTable;

    /**
     * Construct a runnable object that follow a key from the valuesStorage table
     *
     * @param key the key that will be followed used in both tables(in which we follow and in which we save the refference to the runnable)
     * @param valuesStorage the HashTable for which we are going to follow a key
     * @param threadReferencesTable a HashTable in which we save reference to the runnable objects
     */
    public LifecycleThread(String key, Hashtable<String, Object> valuesStorage, Hashtable<String, LifecycleThread> threadReferencesTable) {
        this.key = key;
        this.valuesStorage = valuesStorage;
        this.threadReferencesTable = threadReferencesTable;
    }

    public void run() {
        for (; timeCounter < 100; timeCounter++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + timeCounter);
        }
        valuesStorage.remove(key);
        threadReferencesTable.remove(key);
    }

    public void setTimeCounter(int timeCounter) {
        this.timeCounter = timeCounter;
    }

//    public void setKeyFollowed(String keyFollowed) {
//        this.key = keyFollowed;
//    }
}
