package com.clouway.threads.listwithfixedlength;

/**
 * For creating and managing list with fixed length
 * Created by Krasimir Dimitrov
 */

public class ObjectList {
    private Object[] list;
    private int indexOfList;

    /**
     * Constructor with one parameter
     *
     * @param length the size of our list
     */
    public ObjectList(int length) {
        list = new Object[length];
        indexOfList = 0;
    }

    /**
     * Add an object to the list if there is a free space. Otherwise wait for space
     *
     * @param o the object that we want to add to the list
     */
    public synchronized void add(Object o) {
        if (indexOfList >= list.length) {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting to add");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //    if (o != null) {
        System.out.println(Thread.currentThread().getName() + " is adding at index " + indexOfList);
        list[indexOfList] = o;
        indexOfList++;
        //  } else {
        //     System.out.println("Don't try to add NULL");
        //  }
        notifyAll();
    }

    /**
     * Remove an element from the list if there are elements otherwise wait
     */
    public synchronized void remove() {
        if (indexOfList <= 0) {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting to remove");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " is removing at index " + (indexOfList - 1));
        list[indexOfList - 1] = null;
        indexOfList--;
        notifyAll();
    }


}
