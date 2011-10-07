package com.clouway.objectsinjava.tree;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/20/11
 * Time: 10:03 AM
 * To change this template use File | Settings | File Templates.
 */
class Tree {

    private TreeNode root;

    /**
     * construct a tree
     */
    public Tree() {
        root = null;
    }

    /**
     * insert an element in the tree
     *
     * @param insertValue the element that is inserted in the tree
     */
    public void insertNode(int insertValue) {
        if (root == null) {
            root = new TreeNode(insertValue);
        } else {
            root.insert(insertValue);
        }
    }

    /**
     * sort the tree and print it
     */
    public void inorderTraversel() {
        inorderHelper(root);
    }

    /**
     * sort  a tree and print it - the actual algorithm
     *
     * @param node the node used in the traversal
     */
    private void inorderHelper(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderHelper(node.leftNode);
        System.out.print(node.data + " ");
        inorderHelper(node.rightNode);
    }

    /**
     * check if an element is in the tree
     *
     * @param val the element that we are checking for
     */
    public void findNode(int val) {
        findHelper(root, val);
    }

    /**
     * check if an element is in the tree - the actual algorithm
     *
     * @param node  a node parameter so we can use it's value
     * @param value the element that we are searching for
     */
    private void findHelper(TreeNode node, int value) {
        if (node != null) {
            if (value == node.data)
                System.out.print("Element " + value + " found");
            else {
                if (value < node.data) {
                    node = node.leftNode;
                } else {
                    node = node.rightNode;
                }
                findHelper(node, value);
            }
        } else {
            System.out.print("Element " + value + " NOT found");
        }


    }
}

