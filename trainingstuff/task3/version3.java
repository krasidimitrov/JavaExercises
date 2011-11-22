package task3;

/**
 * Created by Krasimir Dimitrov
 * Date: 11/17/11
 * Time: 10:10 AM
 */
public class version3 implements Runnable {
    private int thread1counter = 0;
    private int thread2counter = 0;
    private boolean enabled = true;
    private int threadNumber;
    private static int threadNumberSetter = 1;

    public version3() {
        this.threadNumber = threadNumberSetter;
        threadNumberSetter++;
    }


    public void run(){
        for(int i=0; i<30; i++){
            if(threadNumber==1)
                try {
                    thread1count();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            if(threadNumber == 2)
                try {
                    thread2count();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

    public synchronized void thread1count() throws InterruptedException {
        if (!enabled) {
            wait();
        }
        Thread.sleep(500);
        thread1counter++;
        System.out.println(Thread.currentThread().getName() + " " + thread1counter);
        enabled = false;
        notify();
    }

    public synchronized void thread2count() throws InterruptedException {
        if (enabled) {
            wait();
        }
        Thread.sleep(2000);
        thread2counter++;
        System.out.println(Thread.currentThread().getName() + " " + thread2counter);
        enabled = true;
        notify();
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new version3());
        Thread thread2 = new Thread(new version3());

        thread1.start();
        thread2.start();
    }
}
