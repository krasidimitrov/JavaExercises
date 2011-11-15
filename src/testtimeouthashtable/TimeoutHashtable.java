package testtimeouthashtable;

import com.sun.deploy.net.proxy.StaticProxyManager;
import test.ThreadCount;

import javax.swing.plaf.metal.MetalBorders;
import java.sql.Time;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/11/11
 * Time: 3:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class TimeoutHashtable implements Runnable {

    private static Hashtable<String, String> autoCleaningTable = new Hashtable<String, String>();
    private int getCount = 0;
    private String key="";
    Scanner in = new Scanner(System.in);
    private static String checker;

    public TimeoutHashtable(String key, String value) {
        this.key = key;
        autoCleaningTable.put(key, value);
    }

    public void run() {
        while (getCount != 10) {
            getCount++;
            System.out.println(getCount);
            System.out.println(autoCleaningTable.get(key));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
      //  System.out.println(autoCleaningTable.get("one"));
        autoCleaningTable.remove(key);
        System.out.println(autoCleaningTable.get(key));
    }

    public void get(){
//         if(in.next().equals("get")){
//         getCount=0;
//        }
//
        checker = in.next();
        if(autoCleaningTable.containsKey(checker)){
            System.out.println(autoCleaningTable.get(checker));
            getCount =0;

        }
    }

    public static void main(String[] args) {
        TimeoutHashtable thread1 = new TimeoutHashtable("one", "first");
        TimeoutHashtable thread2 = new TimeoutHashtable("two", "second");

        ExecutorService app = Executors.newCachedThreadPool();
        app.execute(thread1);
        app.execute(thread2);

        app.shutdown();

    }


}
