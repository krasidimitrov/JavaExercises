package producerconsumer.synchronizedversion;

import producerconsumer.Buffer;
import producerconsumer.Consumer;
import producerconsumer.Producer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/10/11
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class SynchronizedSharedBufferTest {

    public static void main(String[] args) {

        //crete a newCachedThreadPool
        ExecutorService application = Executors.newCachedThreadPool();

        //create SynchronizedBuffer to store ints
        Buffer sharedLocation = new SynchronizedBuffer();

        System.out.printf( "%-40s%s\t\t%s\n%-40s%s\n\n", "Operation", "Buffer", "Occupied", "---------", "------\t\t--------" );

        //execute the Producer and Comsumer tasks
        application.execute(new Producer(sharedLocation));
        application.execute(new Consumer(sharedLocation));

        application.shutdown();
    }
}
