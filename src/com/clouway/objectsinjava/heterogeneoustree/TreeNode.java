package com.clouway.objectsinjava.heterogeneoustree;

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
    Object data;
    int key;

    /**
     * constructor with two parameters
     *
     * @param nodeKey the int key for every node
     * @param obj     the element for every node
     */
    public TreeNode(int nodeKey, Object obj) {
        data = obj;
        key = nodeKey;
        leftNode = rightNode = null;

    }

    /**
     * insert an element in the tree
     *
     * @param insertValue the key value for the element
     * @param obj         the element we insert in the tree
     */
    public void insert(int insertValue, Object obj) {
        if (insertValue < key) {
            if (leftNode == null) {
                leftNode = new TreeNode(insertValue, obj);
            } else {
                leftNode.insert(insertValue, obj);
            }
        }

        if (insertValue > key) {
            if (rightNode == null) {
                rightNode = new TreeNode(insertValue, obj);
            } else {
                rightNode.insert(insertValue, obj);
            }
        }
    }

}
