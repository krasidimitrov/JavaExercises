package com.clouway.introducingjava.arrayreverser;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/16/11
 * Time: 2:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class ArrayReverser {

    /**
     * reverse an array (1 2 3 4 -> 4 3 2 1)
     *
     * @param arr the array which we want to reverse
     */
    public void reverse(int[] arr) {
        int tmp;
        int j = arr.length - 1;
        for (int i = 0; i < arr.length / 2; i++) {
            tmp = arr[i];
            arr[i] = arr[j - i];
            arr[j - i] = tmp;
        }
    }

    /**
     * print an array on the screen
     *
     * @param arr the array that we want to see
     */
    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

}
