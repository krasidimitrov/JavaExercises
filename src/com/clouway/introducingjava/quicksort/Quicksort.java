package com.clouway.introducingjava.quicksort;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/16/11
 * Time: 11:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class Quicksort {

    /**
     * sort the array which we want
     *
     * @param arrHelp the array  that is sorted by quciksort method
     */
    public void quicksort(int[] arrHelp) {
        this.quicksortAlgorithm(arrHelp, 0, arrHelp.length - 1);
    }

    /**
     * sort an array using the quicksort method
     *
     * @param arr   the array which we sort
     * @param left  the index of the lower element of the partition that we sort
     * @param right the index of the upper element of the partition that we sort
     */
    private void quicksortAlgorithm(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int tmp;
        int comp = arr[(left + right) / 2];

        do {
            while (arr[i] < comp) i++;
            while (arr[j] > comp) j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        } while (i <= j);

        if (left < j) quicksortAlgorithm(arr, left, j);
        if (i < right) quicksortAlgorithm(arr, i, right);
    }

    /**
     * show an array on the screen
     *
     * @param arr the array that we want to see on the screen
     */
    protected void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}
