package multicounter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/11/11
 * Time: 10:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class SharedCountTest {

    public static void main(String[] args) {

        ExecutorService application = Executors.newCachedThreadPool();

        Counter counter = new Counter();

        application.execute(new Thread1(counter, 100));
        application.execute(new Thread2(counter, 2000));

        System.out.println("THIS IS THE COUNTER:"+counter.getCount());

        application.shutdown();
    }

}
