package producerconsumer.blockingbuffer;

import producerconsumer.Buffer;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/10/11
 * Time: 11:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class BlockingBuffer implements Buffer {

    private final ArrayBlockingQueue<Integer> buffer; //shared buffer

    public BlockingBuffer()
    {
        buffer = new ArrayBlockingQueue<Integer>(1);
    }

    //place value into buffer
    public void set(int value) throws InterruptedException{
        buffer.put(value);//place value in buffer
        System.out.printf("%s%2d\t%s%d\n", "Producer writes ", value, "Buffer cells occupied: ", buffer.size());
    }

    //return value from buffer
    public int get() throws InterruptedException{
        int readValue = buffer.take(); //remove value from buffer
        System.out.printf("%s%2d\t%s%d\n", "Consumer reads ", readValue, "Buffer cells occupied: ", buffer.size());

        return readValue;
    }
}
