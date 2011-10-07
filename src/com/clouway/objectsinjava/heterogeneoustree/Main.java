package com.clouway.objectsinjava.heterogeneoustree;

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
        Dog jaffy = new Dog("Sparky", 12);

        tree.insertNode(5, "asdas");
        tree.insertNode(7, 21);
        tree.insertNode(2, "der");
        tree.insertNode(3, "fg");
        tree.insertNode(6, 13);
        tree.insertNode(8, jaffy);
        tree.insertNode(-3, 12);
        tree.inorderTraversel();

    }
}