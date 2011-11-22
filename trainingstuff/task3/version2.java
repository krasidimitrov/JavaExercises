package task3;

/**
 * Created by Krasimir Dimitrov
 * Date: 11/17/11
 * Time: 9:52 AM
 */
public class version2 implements Runnable {
    private int count = 0;

    public synchronized void run() {
        for (; count < 20; count++) {
            try {
                System.out.println(Thread.currentThread().getName() + " " + count);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
                        notifyAll();
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new version2());
        Thread thread2 = new Thread(new version2());

        thread1.start();
        thread2.start();
    }
}
