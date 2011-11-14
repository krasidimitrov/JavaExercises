package producerconsumer.blockingbuffer;

import producerconsumer.Buffer;
import producerconsumer.Consumer;
import producerconsumer.Producer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/10/11
 * Time: 1:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class BlockingBufferTest {

    public static void main(String[] args) {

        //create new thread pool with two threads
        ExecutorService application = Executors.newCachedThreadPool();

        //create BlockingBuffer to store ints
        Buffer sharedLocation = new BlockingBuffer();

        application.execute(new Producer(sharedLocation));
        application.execute(new Consumer(sharedLocation));


    }
}
