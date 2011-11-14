package test;

import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/10/11
 * Time: 5:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreadCount implements Runnable{
    int count = 0;
    private boolean enabled = true;
    Scanner in = new Scanner(System.in);


    public void run(){
        while(enabled == true){
            count++;
            System.out.println(count);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    public void stopCount(){
        if(in.nextLine() != ""){
            enabled=false;
            System.out.println(count);
        }
    }


    public static void main(String[] args) {

        ExecutorService application = Executors.newCachedThreadPool();
        ThreadCount threadCount = new ThreadCount();
        application.execute(threadCount);

        threadCount.stopCount();

        application.shutdown();

    }
}
