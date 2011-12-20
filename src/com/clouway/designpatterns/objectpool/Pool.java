package com.clouway.designpatterns.objectpool;

import java.util.LinkedList;
import java.util.List;

/**
 * Object pool manager
 * Created by Krasimir Dimitrov
 * Date: 12/16/11
 * Time: 4:44 PM
 */
public class Pool {

    private LinkedList<Object> freeCars;
    private LinkedList<Object> takenCars;
    private int poolLimit;

    /**
     * Constructor with one parameter
     * @param poolLimit the limit of how many instances you can have
     */
    public Pool(int poolLimit) {
        this.poolLimit = poolLimit;
        this.freeCars = new LinkedList<Object>();
        this.takenCars = new LinkedList<Object>();
    }

    /**
     * acquire object from the pool to use iit(create new if there are no free objects and the limit is not reached)
     */
    public void acquire() {
        if (freeCars.isEmpty() && takenCars.size() < poolLimit) {
            takenCars.add(new Car());
        } else if (!freeCars.isEmpty()) {
            takenCars.add(freeCars.getLast());
            freeCars.removeLast();
        } else {
            throw new PoolDoesNotHaveFreeElementsException();
        }
    }

    /**
     * return objects to the pool so they can be used again
     */
    public void release() {
        if (!takenCars.isEmpty()) {
            freeCars.add(takenCars.getLast());
            takenCars.removeLast();
        } else {
            throw new NoTakenElemenetsException();
        }
    }
}
