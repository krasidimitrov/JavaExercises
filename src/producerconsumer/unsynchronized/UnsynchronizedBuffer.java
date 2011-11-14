package producerconsumer.unsynchronized;

import producerconsumer.Buffer;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/10/11
 * Time: 11:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class UnsynchronizedBuffer implements Buffer {

    private int buffer = -1; //shared by producer and consumer threads

    //place value into buffer
    public void set(int value) throws InterruptedException {
        System.out.printf("Producer writes\t%2d", value);
        buffer = value;
    }

    //return value from buffer
    public int get() throws InterruptedException {
        System.out.printf("Consumer reads\t%2d", buffer);
        return buffer;
    }
}
