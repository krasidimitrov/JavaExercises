package com.clouway.exceptions.stringsumator;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/19/11
 * Time: 9:22 AM
 * To change this template use File | Settings | File Templates.
 */
class Main {
    public static void main(String[] args) {
        Sumator sumator1 = new Sumator();
        String a = "14.3";
        String b = null;

        try {
        System.out.println(sumator1.sum(a, b));
        }
        catch (NumberFormatException e)
        {
          System.err.print("Illegal string. Use only numbers");
        }

    }
}
