package arraywiththreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/10/11
 * Time: 9:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class SharedArrayTest {

    public static void main(String[] args) {

        SimpleArray sharedSimpleArray = new SimpleArray(6);
        ArrayWriter writer1 = new ArrayWriter(1, sharedSimpleArray);
        ArrayWriter writer2 = new ArrayWriter(11, sharedSimpleArray);

        //execute the tasks with an ExecutorService
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(writer1);
        executor.execute(writer2);

        executor.shutdown();

        try {
            //wait 1 minute for both writers to finish executing
            boolean tasksEnded = executor.awaitTermination(1, TimeUnit.MINUTES);

            if (tasksEnded) {
                System.out.println(sharedSimpleArray);//print contents
            } else {
                System.out.println("Timed out while waiting for tasks to finish,");
            }
        } catch (InterruptedException ex) {
            System.out.println("Interrupted while waiting for tasks to finish");
        }
    }
}
