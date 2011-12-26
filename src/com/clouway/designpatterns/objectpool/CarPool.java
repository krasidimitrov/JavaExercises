package com.clouway.designpatterns.objectpool;

import java.util.LinkedList;

/**
 * Class used as object pool for cars
 * Created by Krasimir Dimitrov
 * Date: 12/26/11
 * Time: 9:48 AM
 */
public class CarPool {
    private LinkedList<Car> freeCars = new LinkedList<Car>();
    private LinkedList<Car> takenCars = new LinkedList<Car>();
    private int carPoolLimit;

    /**
     * Constructor with one parameter
     *
     * @param carPoolLimit the limit of how many instances you can have
     */
    public CarPool(int carPoolLimit) {

        this.carPoolLimit = carPoolLimit;
    }

    /**
     * acquire object from the pool to use iit(create new if there are no free objects and the limit is not reached)
     *
     * @return the acquired car
     */
    public Car acquire() {
        if (freeCars.isEmpty() && takenCars.size() < carPoolLimit) {
            takenCars.add(new Car());
        } else if (!freeCars.isEmpty()) {
            takenCars.add(freeCars.getLast());
            freeCars.removeLast();
        } else {
            throw new PoolDoesNotHaveFreeElementsException();
        }
        return takenCars.getLast();
    }

    /**
     * return objects to the pool so they can be used again
     */
    public void release() {
        if (!takenCars.isEmpty()) {
            freeCars.add(takenCars.getLast());
            takenCars.removeLast();
        } else {
            throw new NoTakenElementsToReleaseException();
        }
    }
}
