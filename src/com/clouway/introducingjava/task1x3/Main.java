package com.clouway.task1x3;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/17/11
 * Time: 5:20 PM
 * To change this template use File | Settings | File Templates.
 */
class Main {
    public static void main(String[] args) {
        Quicksort qs = new Quicksort();
        int[] arr1 = {3, 1, 5, 7, -2, 8, 2, 4, 4, 9, 6, -3};
        qs.quicksort(arr1);
        qs.printArr(arr1);
    }
}
