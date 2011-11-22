package com.clouway.threads.autocleaninghashtable;

import java.util.Hashtable;

/**
 * For creating and managing a HashTable which clear itself after some life span of a key
 * Created by Krasimir Dimitrov.
 */

public class AutocleaningTable {

    private Hashtable<String, Object> valuesStorage = new Hashtable<String, Object>();
    private Hashtable<String, LifecycleThread> threadReferencesTable = new Hashtable<String, LifecycleThread>();
    private LifecycleThread keyFollower;

    /**
     * Put an object in the hash table and start a counter for the life time of the key if this is the first time this key is used
     *
     * @param key    the key  with which we add the object to the table
     * @param object the object that we want to add to the table
     */
    public void put(String key, Object object) {
        if (valuesStorage.containsKey(key)) {
            valuesStorage.put(key, object);
            threadReferencesTable.get(key).setTimeCounter(0);
        } else {
            Thread thread = new Thread(keyFollower = new LifecycleThread(key, valuesStorage, threadReferencesTable));
            threadReferencesTable.put(key, keyFollower);
            thread.start();
            valuesStorage.put(key, object);
        }
    }

    /**
     * Get an object from the table by its key and reset the timer
     *
     * @param key the key of the object we want to get
     * @return the object if exist else return null
     */
    public Object get(String key) {
        if (valuesStorage.containsKey(key)) {
            threadReferencesTable.get(key).setTimeCounter(0);
            return threadReferencesTable.get(key);
        } else {
            return null;
        }
    }
}
