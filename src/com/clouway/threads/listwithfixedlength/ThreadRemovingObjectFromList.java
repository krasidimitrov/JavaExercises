package com.clouway.threads.listwithfixedlength;

/**
 * Runnable object that use the ObjectList.class remove method
 * Created by Krasimir Dimitrov
 */

public class ThreadRemovingObjectFromList implements Runnable {

    private ObjectList list;

    public ThreadRemovingObjectFromList(ObjectList list) {
        this.list = list;
    }

    public void run() {
        list.remove();
    }
}
