package producerconsumer.synchronizedversion;

import producerconsumer.Buffer;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/10/11
 * Time: 1:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class SynchronizedBuffer implements Buffer {

    private int buffer = -1; //shared by producer and consumer threads
    private boolean occupied = false; //whether the buffer is occupied

    //place value into buffer
    public synchronized void set(int value) throws InterruptedException{

        //while there are no empty locations, place thread in waiting state
        while(occupied){
            //output thread information and buffer information, then wait
            System.out.println("Producer tries to write.");
            displayState("Buffer full. Producer waits.");
            wait();
        }

        buffer = value; //set new buffer value

        //indicate producer cannot store another value until consumer retrieves current buffer value
        occupied = true;

        displayState("Producer writes "+buffer );

        //tell waiting thread(s) to enter runnable state
        notifyAll();
    }

    //return value from buffer
    public synchronized int get() throws InterruptedException{

        //while no data to read, place thread in waiting state
        while(!occupied){
            //output thread information and buffer information, then wait
            System.out.println("Consumer tries to read.");
            displayState("Buffer empty. Consumer waits.");
            wait();
        }

        //indicate that producer can store another value because consumer just retrieved buffer value
        occupied = false;

        displayState("Consumer reads "+ buffer);
        notifyAll();//tell waiting thread(s) to enter runnable state

        return buffer;
    }

    public void displayState(String operation){
        System.out.printf("%-40s%d\t\t%b\n\n", operation, buffer, occupied);
    }
}
