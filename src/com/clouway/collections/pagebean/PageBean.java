package com.clouway.collections.pagebean;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 10/18/11
 * Time: 5:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class PageBean<T> {

    private List<T> list;
    private int numberOfPages;
    private int index = 0;
    private int pageSize = 3;
    public List<T> page;
    public List<T> empty;


    public PageBean(List<T> list) {
        this.list = list;
        numberOfPages = getNumberOfPages();
    }

    /**
     * check how many pages are in the list
     *
     * @return the number of pages  of the list
     */
    private int getNumberOfPages() {
        int checker = list.size() % pageSize;
        if (checker == 0) {
            numberOfPages = list.size() / pageSize;
        } else {
            numberOfPages = list.size() / pageSize + 1;
        }
        return numberOfPages;

    }

    /**
     * show the elements on the next page
     *
     * @return subList with the elements on the next page
     */
    public List<T> next() {
        getNumberOfPages();
        if (index != numberOfPages) {
            index++;

            if (index == numberOfPages) {
                page = list.subList((index - 1) * pageSize, list.size());
            } else {
                page = list.subList((index - 1) * pageSize, index * pageSize);
            }
            return page;
        } else {
            return empty;
        }

    }

    /**
     * check if there are more pages
     *
     * @return false if there are no more pages else return true
     */
    public boolean hasNext() {
        getNumberOfPages();
        if (index >= numberOfPages) {
            return false;
        } else {
            return true;
        }

    }

    /**
     * set the first page as current
     *
     * @return a subList with the elements on the first page
     */
    public List<T> firstPage() {
        index = 0;
        return next();
    }

    /**
     * set the last page as current
     *
     * @return a subList with the elements on the last page
     */
    public List<T> lastPage() {
        getNumberOfPages();
        index = numberOfPages;
        page = list.subList((index - 1) * pageSize, list.size());
        return page;
    }

    /**
     * show the elements on the previous page
     *
     * @return a sublist with the elements on the previous page
     */
    public List<T> previous() {
        numberOfPages = getNumberOfPages();
        if (index <= 1) {
            System.out.println("No previous elements");
            return empty;
        } else {
            page = list.subList((index - 2) * pageSize, (index - 1) * pageSize);
            index--;
            return page;
        }

    }

    /**
     * check if there is a previous pages
     *
     * @return false if there isn't else return true
     */
    public boolean hasPrevious() {
        if (index <= 1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * @return the current page(index)
     */
    public int getCurrentIndex() {
        return index;
    }


    /**
     * print the elements of the lsit
     */
    public void print() {
        for (T element : list) {
            System.out.println(element + " ");
        }
    }

    public int getCurrentPageNumber() {
        if (index == 0) {
            return -1;
        } else {
            return index;
        }
    }


}
