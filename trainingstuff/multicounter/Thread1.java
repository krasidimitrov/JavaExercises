package multicounter;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/11/11
 * Time: 10:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class Thread1 implements Runnable {

    private int thread1Count;
    Counter sharedCounter = new Counter();

    public Thread1(Counter counter, int threadMaxCount) {
        thread1Count = threadMaxCount;
        sharedCounter = counter;
        if (sharedCounter.getCount() > threadMaxCount) {
            sharedCounter.setCount(threadMaxCount);
        }
    }

    public void run() {
        for (int i = 0; i <= thread1Count; i++) {
            System.out.println(i);
            if (i == sharedCounter.getCount()) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
