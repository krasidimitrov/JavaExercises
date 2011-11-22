package task2;

/**
 * Created by Krasimir Dimitrov
 * Date: 11/22/11
 * Time: 1:29 PM
 */
public class ThreadCounterAgain implements Runnable {
    private CounterClass sharedCounter;
    private Thread referenceThread;
    private int maxCount;

    public ThreadCounterAgain(int maxCount, CounterClass sharedCounter) {
        this.maxCount = maxCount;
        this.sharedCounter = sharedCounter;
    }


    public void run() {

        if(sharedCounter.count(maxCount) == maxCount){
                 referenceThread.interrupt();
        };

    }

    public void setReference(Thread thread) {
        referenceThread = thread;
    }
}