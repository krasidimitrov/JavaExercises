package com.clouway.task1x2;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/16/11
 * Time: 10:47 AM
 * To change this template use File | Settings | File Templates.
 */
class Array {

    /**
     * find and print the minimal element of the array
     *
     * @param array the array from which we find the minimal element
     */
    public int getMinElement(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) min = array[i];
        }

        return min;
    }

    /**
     * find the sum of all elements of an array
     *
     * @param array the array of which we find the sum of all elements
     */
    public int getSum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }

        return sum;
    }

    /**
     * print an array on the screen
     *
     *
     * @param array the array which we print on the screen
     */
    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
    }

}
