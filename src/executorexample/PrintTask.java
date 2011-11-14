package executorexample;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/9/11
 * Time: 4:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class PrintTask implements Runnable {

    private final int sleepTime;// random sleep time for thread
    private final String taskName; //name of taks
    private final static Random generator = new Random();

    //constructor
    public PrintTask(String name) {
        //set task name
        taskName = name;

        //pick random sleep time between 0 and 5 seconds
        sleepTime = generator.nextInt(5000);
    }

    //method run contains the code that a thread will execute
    public void run() {
        try {
            System.out.printf("%s going to sleep for %d milliseconds. \n", taskName, sleepTime);
            Thread.sleep(sleepTime); //put thread to sleep
        } catch (InterruptedException exception) {
            System.out.printf("%s %s\n", taskName, "terminated prematurely due to interruption");
        }
        System.out.printf( "%s done sleeping\n", taskName );
    }
}
