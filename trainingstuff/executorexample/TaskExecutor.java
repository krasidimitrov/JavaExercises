package executorexample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/9/11
 * Time: 4:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class TaskExecutor {

    public static void main(String[] args) {

        //create and name each runnable
        PrintTask task1 = new PrintTask("task1");
        PrintTask task2 = new PrintTask("task2");
        PrintTask task3 = new PrintTask("SynchronizedDependentCounter");

        System.out.println("Starting Executor");

        //create ExecutorService to manage threads
        ExecutorService threadExecutor = Executors.newCachedThreadPool();

        //start thread and in runnable state
        threadExecutor.execute(task1);
        threadExecutor.execute(task2);
        threadExecutor.execute(task3);

        //shut down worker threads when their tasks complete
        threadExecutor.shutdown();

        System.out.println("Tasks started, main ends. \n");
    }
}
