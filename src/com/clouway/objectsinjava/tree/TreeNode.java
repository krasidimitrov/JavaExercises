package com.clouway.objectsinjava.tree;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/20/11
 * Time: 9:53 AM
 * To change this template use File | Settings | File Templates.
 */
class TreeNode {

    TreeNode leftNode;
    TreeNode rightNode;
    int data;

    /**
     * constructor  with one parameter
     *
     * @param nodeData the value of a node
     */
    public TreeNode(int nodeData) {
        data = nodeData;
        leftNode = rightNode = null;

    }

    /**
     * insert an node and doesn't allow any value to repeat
     *
     * @param insertValue the value that we enter in this node
     */
    public void insert(int insertValue) {
        if (insertValue < data) {
            if (leftNode == null) {
                leftNode = new TreeNode(insertValue);
            } else {
                leftNode.insert(insertValue);
            }
        }

        if (insertValue > data) {
            if (rightNode == null) {
                rightNode = new TreeNode(insertValue);
            } else {
                rightNode.insert(insertValue);
            }
        }
    }

}
