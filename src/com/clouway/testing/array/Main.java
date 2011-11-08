package com.clouway.testing.array;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 10/28/11
 * Time: 3:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
      public static void main(String[] args) {
        Array meth = new Array();
        int[] arr = {3,1,5,2,-1,3};
        System.out.println(meth.getMinElement(arr));
        System.out.println(meth.getSum(arr));
        meth.printArray(arr);
    }
}
