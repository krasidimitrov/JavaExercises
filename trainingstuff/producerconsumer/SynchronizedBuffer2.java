package producerconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/10/11
 * Time: 4:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class SynchronizedBuffer2 implements Buffer {

    //lLock to control synchronization with this buffer
    private final Lock accessLock = new ReentrantLock();

    //conditions to control reading and writing
    private final Condition canWrite = accessLock.newCondition();
    private final Condition canRead = accessLock.newCondition();

    private int buffer = -1; //shared by producer and consumer threads
    private boolean occupied = false; //whether buffer is occupied

    public void set(int value) throws InterruptedException {

        accessLock.lock(); //lock this object

        //output thread information and buffer information, then wait
        try {
            //while buffer is not empty, place thread in waiting state
            while (occupied) {
                System.out.println("Producer tries to write.");
                displayState("Buffer full. Producer waits.");
                canWrite.await(); //wait until buffer is empty
            }

            buffer = value; //set new buffer value

            //indicate producer cannot store another value
            //until consumer retrieves current buffer value
            occupied = true;

            displayState("Producer writes " + buffer);

            //signal any threads waiting to read from buffer
            canRead.signalAll();
        } finally {
            accessLock.unlock(); //unlock this object
        }
    }

    public int get() throws InterruptedException {

        int readValue = 0; //initialize value read from buffer
        accessLock.lock(); //lock this object

        //output thread information and buffer information, then wait
        try {
            //if there is no data to read, place thread in waiting state
            while (!occupied) {
                System.out.println("Consumer tries to read.");
                displayState("Buffer emplty. Consumer waits.");
                canRead.await(); //wait until buffer is full
            }

            //indicate that producer can store another value
            //because consumer just retrieved buffer value
            occupied = false;

            readValue = buffer; //retrieve value from buffer
            displayState("Consumer reads " + readValue);

            //signal any thread waiting for buffer to be empty
            canWrite.signalAll();
        } finally {
            accessLock.unlock(); //unlock this object
        }

        return readValue;
    }

    public void displayState(String operation) {
        System.out.printf("%-40s%d\t\t\t%b\n\n", operation, buffer, occupied);
    }
}
