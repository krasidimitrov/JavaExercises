package test;

import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;
import sun.awt.windows.ThemeReader;
import sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl;

import java.nio.channels.InterruptibleChannel;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/10/11
 * Time: 5:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class MultipleThreadCount implements Runnable {

    private int count;
    Thread referenceThread;

    public MultipleThreadCount(int count) {
        this.count = count;
    }


    public void run() {
 synchronized (this){

        int i = 0;
        while (i < count) {
            i++;
            System.out.println(Thread.currentThread().getName()+ " " +i);
            try {
             //  Thread.sleep(222);;
                wait();
                notify();
            } catch (InterruptedException e) {
                return;
            }
        }
 }


        Thread.currentThread().interrupt();
        referenceThread.interrupt();

    }

    public void setReference(Thread thread){
        referenceThread = thread;

    }


    public static void main(String[] args) {
        MultipleThreadCount thread1 = new MultipleThreadCount(5);
        MultipleThreadCount thread2 = new MultipleThreadCount(10);

        Thread threadOne = new Thread(thread1);
        Thread threadTwo = new Thread(thread2);

        thread1.setReference(threadTwo);
        thread2.setReference(threadOne);

        threadOne.start();
        threadTwo.start();

    }
}
