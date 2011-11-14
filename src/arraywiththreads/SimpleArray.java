package arraywiththreads;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/10/11
 * Time: 9:27 AM
 * To change this template use File | Settings | File Templates.
 */
//CAUTION : NOT THREAD SAFE IF WE REMOVE SYNCHRONIZED from add method
public class SimpleArray {

    //the shared indeger array
    private final int[] array;
    //index of next element to be written
    private int writeIndex = 0;
    private final static Random generator = new Random();

    //construct a SimpleArray of a given size
    public SimpleArray(int size) {
        array = new int[size];
    }

    //add a value to the shared array
    public synchronized void add(int value) {
        int position = writeIndex; // store the write index

        try {
            //put thread to sleep for 0-499milliseconds
            Thread.sleep(generator.nextInt(500));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        //put value in the appropriate element
        array[position] = value;
        System.out.printf("%s wrote %2d to element %d. \n", Thread.currentThread().getName(), value, position);

          ++writeIndex;
        System.out.printf( "Next write index: %d\n", writeIndex );

    }

    public String toString() {
        return "\nContents of SimpleArray:\n" + Arrays.toString(array);
    }
}
