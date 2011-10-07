package com.clouway.exceptions.listwithfixedlength;


/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/28/11
 * Time: 5:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class ObjectList {
    Object[] list;
    int indexOfList;

    /**
     * constructor with one parameter
     *
     * @param length the size of our list
     */
    public ObjectList(int length) {
        list = new Object[length];
        indexOfList = 0;
    }

    /**
     * add an element at the end of the list
     *
     * @param o the element that is added
     * @throws ListFullException when the list is full and you can't add more elements
     */
    public void add(Object o) throws ListFullException {
        if (indexOfList >= list.length) {
            throw new ListFullException();
        }
        if (o != null) {
            list[indexOfList] = o;
            indexOfList++;
        } else {
            System.out.println("Don't try to add NULL");
        }
    }

    /**
     * print all the elements of the list
     */
    public void printAllElements() {

        for (int i = 0; i < indexOfList; i++) {
                System.out.print(list[i] + " ");

        }
        System.out.println();

    }

    /**
     * remove an element from the end of the list
     *
     * @throws ListEmptyException when the list is empty and you can' remove anymore
     */
    public void remove() throws ListEmptyException {
        if (indexOfList <= 0) {
            throw new ListEmptyException();
        }
        list[indexOfList - 1] = null;
        indexOfList--;
    }
}
