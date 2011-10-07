package com.clouway.objectsinjava.heterogeneoustree;

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
     * constructor without parameters
     */
    public Tree() {
        root = null;
    }

    /**
     * insert a Node in the tree
     *
     * @param insertKey the int key we use to insert the element in the tree
     * @param obj       the element we insert in the tree
     */
    public void insertNode(int insertKey, Object obj) {
        if (root == null) {
            root = new TreeNode(insertKey, obj);
        } else {
            root.insert(insertKey, obj);
        }
    }

    /**
     * sort the tree and print it
     */
    public void inorderTraversel() {
        inorderHelper(root);
    }

    /**
     * sort the tree - the real function
     *
     * @param node a node object used for the sorting
     */
    private void inorderHelper(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderHelper(node.leftNode);
        System.out.print(node.key + "/" + node.data + " ");
        inorderHelper(node.rightNode);
    }

}

