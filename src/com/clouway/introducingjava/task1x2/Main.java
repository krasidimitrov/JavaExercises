package com.clouway.task1x2;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/17/11
 * Time: 5:11 PM
 * To change this template use File | Settings | File Templates.
 */
class Main {
    public static void main(String[] args) {
        Array meth = new Array();
        int[] arr;
        arr = new int[5];
        arr[0] = 3;
        arr[1] = 5;
        arr[2] = 1;
        arr[3] = 2;
        arr[4] = 7;
        System.out.println(meth.getMinElement(arr));
        System.out.println(meth.getSum(arr));
        meth.printArray(arr);
    }
}
