package com.clouway.threads.listwithfixedlength;

/**
 * Created by Krasimir Dimitrov
 */

public class Main {
    public static void main(String[] args) {

        ObjectList list = new ObjectList(3);

        new Thread(new ThreadAddingObjectInList(list)).start();
        new Thread(new ThreadAddingObjectInList(list)).start();
        new Thread(new ThreadAddingObjectInList(list)).start();
        new Thread(new ThreadAddingObjectInList(list)).start();
        new Thread(new ThreadRemovingObjectFromList(list)).start();
    }
}
