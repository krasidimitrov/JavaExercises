package producerconsumer.unsynchronized;

import producerconsumer.Buffer;
import producerconsumer.Consumer;
import producerconsumer.Producer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/10/11
 * Time: 11:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class SharedBufferTest {

    public static void main(String[] args) {
        //create new thread pool with two threads
        ExecutorService application = Executors.newCachedThreadPool();

        //Create UnsynchronizedBuffer to store ints
        Buffer sharedLocation = new UnsynchronizedBuffer();

        System.out.println("Action\t\tValue\tSum of Producer\tSum of Consumed");
        System.out.println("------\t\t-----\t---------------\t---------------\n");

        //execute the Producer and Consumer, giving each of them access to sharedLocation
        application.execute(new Producer(sharedLocation));
        application.execute(new Consumer(sharedLocation));

        //terminate application when tasks complete
        application.shutdown();

    }
}
