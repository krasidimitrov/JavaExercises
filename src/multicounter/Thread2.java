package multicounter;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/11/11
 * Time: 10:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class Thread2 implements Runnable {

    private int thread2Count;
    Counter sharedCounter = new Counter();

    public Thread2(Counter counter, int threadMaxCount) {
        thread2Count = threadMaxCount;
        sharedCounter = counter;
        if (sharedCounter.getCount() > threadMaxCount) {
            sharedCounter.setCount(threadMaxCount);
        }
    }

    public void run() {
        for (int i = 0; i <= thread2Count; i++) {
            System.out.println(i);
            if (i == sharedCounter.getCount()) {
                Thread.currentThread().interrupt();
            }
        }

//        int i =0;
//        while(i!=thread2Count){
//            i++                 ;
//            System.out.println(i);
//            if(i==sharedCounter.getCount()){
//                Thread.currentThread().interrupt();
//            }
//        }
    }
}
