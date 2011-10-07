package com.clouway.exceptions.listwithfixedlength;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/28/11
 * Time: 5:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        ObjectList test = new ObjectList(5);
        ObjectList test2 = new ObjectList(5);
        try {
            test.printAllElements();
            test.add("dsa");
            test.add(3);
            test.add("pras4o");
            test.add(-12.3);
            test.add(2);
            //test.add("banan");
            test.printAllElements();
            test.remove();


            //test2.remove();


        } catch (ListFullException e) {
            System.err.print("List is full. Element not added");

        } catch (ListEmptyException e){
            System.err.print("List is empty. Nothing to remove");
        }


    }

}