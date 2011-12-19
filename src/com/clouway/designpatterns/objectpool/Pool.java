package com.clouway.designpatterns.objectpool;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/16/11
 * Time: 4:44 PM
 */
public class Pool {

    private LinkedList<Object> freeCars;
    private LinkedList<Object> takenCars;
    private int poolLimit;

    public Pool(int poolLimit) {
        this.poolLimit = poolLimit;
        this.freeCars = new LinkedList<Object>();
        this.takenCars = new LinkedList<Object>();
    }

//    public void addToPool(Car car) {
//        if (existingCars < freeCarsPool.length)
//            for (int i = 0; i < freeCarsPool.length; i++) {
//                if (freeCarsPool[i] == null) {
//                    freeCarsPool[i] = car;
//                    existingCars++;
//                    break;
//                }
//            }
//        else {
//            throw new PoolLimitExceededException();
//        }
//    }

    private boolean isEmpty(Object[] array) {
        for (Object anArray : array) {
            if (anArray != null)
                return false;
        }
        return true;
    }

    private boolean isNotFull(List<Object> array) {
        for (Object anArray : array) {
            if (anArray == null)
                return true;
        }
        return false;
    }

    public void acquire() {

        if (freeCars.isEmpty() && takenCars.size() < poolLimit) {
            System.out.println("CASE 1");
            takenCars.add(new Car());
        } else if (!freeCars.isEmpty()) {
            System.out.println("CASE 2");
            takenCars.add(freeCars.getLast());
            freeCars.removeLast();
        } else {
            throw new PoolDoesNotHaveFreeElementsException();
        }
    }

    public void release() {
        if (!takenCars.isEmpty()) {
            freeCars.add(takenCars.getLast());
            takenCars.removeLast();
        } else {
            throw new NoTakenElemenetsException();
        }
    }
}
