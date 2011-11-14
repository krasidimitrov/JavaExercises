package test;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/14/11
 * Time: 11:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class task3 implements Runnable{

    private int count;
    private int thread1counter=0;
    private int thread2counter=0;
    private boolean enabled = true;
    //task3 dasada;
    //Thread test = new Thread(dasada);

    Thread referenceThread;

    public task3(int count) {
        this.count = count;
    }


    public void run() {

    }

    public synchronized void thread1count() throws InterruptedException {
        if(!enabled){
                wait();
        }

            Thread.sleep(500);
            thread1counter++;
            System.out.println(Thread.currentThread().getName() + " " + thread1counter);
            enabled=false;
            notify();

    }

      public synchronized void thread2count() throws InterruptedException {
          if(enabled){

                        wait();

          }
          Thread.sleep(500);
                    thread2counter++;
              System.out.println(Thread.currentThread().getName() + " " + thread2counter);
                    enabled=true;
              notify();



    }

    public void setReference(Thread thread){
          referenceThread = thread;

    }



    public static void main(String[] args) {
        final task3 thread = new task3(30);

        new Thread(new Runnable() {
            public void run() {
                for (int i=0; i < 30; i++) {
                    try {
                        thread.thread1count();
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                for (int i=0; i < 30; i++) {
                    try {
                        thread.thread2count();
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            }
        }).start();
    }
}
