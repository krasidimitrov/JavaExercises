package listwithfixedlength;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/14/11
 * Time: 2:05 PM
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


    public synchronized void add(Object o)  {
        if (indexOfList >= list.length) {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting to add");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    //    if (o != null) {
        System.out.println(Thread.currentThread().getName() + " is adding at index " + indexOfList);
            list[indexOfList] = o;
            indexOfList++;
      //  } else {
       //     System.out.println("Don't try to add NULL");
      //  }
        notify();
    }


    public void printAllElements() {

        for (int i = 0; i < indexOfList; i++) {
                System.out.print(list[i] + " ");

        }
        System.out.println();

    }


    public synchronized void remove() {
        if (indexOfList <= 0) {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting to remove");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
            System.out.println(Thread.currentThread().getName() + " is removing at index " + (indexOfList-1));
        list[indexOfList - 1] = null;
        indexOfList--;
        notify();
    }
}
