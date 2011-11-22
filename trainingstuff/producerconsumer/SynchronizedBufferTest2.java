package producerconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/10/11
 * Time: 4:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class SynchronizedBufferTest2 {

    public static void main(String[] args) {

        //create new thread pool with two threads
        ExecutorService application = Executors.newCachedThreadPool();

        //create SynchronizedBuffer to store ints
        Buffer sharedLocation = new SynchronizedBuffer2();

        System.out.printf("%-40s%s\t\t%s\n%-40s%s\n\n", "Operation", "Buffer", "Occupied", "---------", "------\t\t--------");

        //execute the Producer and Consumer tasks
        application.execute(new Producer(sharedLocation));
        application.execute(new Consumer(sharedLocation));

        application.shutdown();
    }
}
