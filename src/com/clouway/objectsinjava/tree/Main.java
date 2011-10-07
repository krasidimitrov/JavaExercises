package com.clouway.objectsinjava.tree;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/20/11
 * Time: 10:19 AM
 * To change this template use File | Settings | File Templates.
 */
class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();
        int value;
        Random randomNumber = new Random();

        // for(int i=0; i<10; i++){
        //    value = randomNumber.nextInt(100);
        //   tree.insertNode(value);
        //  }

        tree.insertNode(5);
        tree.insertNode(7);
        tree.insertNode(2);
        tree.insertNode(3);
        tree.insertNode(6);
        tree.insertNode(3);
        tree.insertNode(-3);
        tree.inorderTraversel();
        tree.findNode(-10);

    }
}
