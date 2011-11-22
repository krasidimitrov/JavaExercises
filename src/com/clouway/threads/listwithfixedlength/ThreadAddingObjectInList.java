package com.clouway.threads.listwithfixedlength;

/**
 * Runnable object that use the ObjectList.class add method
 * Created by Krasimir Dimitrov.
 */

public class ThreadAddingObjectInList implements Runnable {

    private ObjectList list;

    public ThreadAddingObjectInList(ObjectList list) {
        this.list = list;
    }

    public void run() {
        list.add(10);
    }
}
