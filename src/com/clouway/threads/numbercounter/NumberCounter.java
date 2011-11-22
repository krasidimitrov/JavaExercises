package com.clouway.threads.numbercounter;

/**
 * For creating  and increasing a counter object for numbers
 * Created by Krasimir Dimitrov
 */

public class NumberCounter {

    private int count = 0;

    public int getCount() {
        return count;
    }

    /**
     * Increase count +1
     */
    public void increaseCount() {
        count++;
    }


}
