package com.clouway.introducingjava.arrayreverser;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/17/11
 * Time: 5:25 PM
 * To change this template use File | Settings | File Templates.
 */
class Main {
    public static void main(String[] args) {
        ArrayReverser ar = new ArrayReverser();
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 4, 5, 6};

        ar.reverse(arr1);
        ar.printArray(arr1);
        ar.reverse(arr2);
        ar.printArray(arr2);

    }
}
