package testtimeouthashtable.version2;

import java.security.Key;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Krasimir Dimitrov
 * Date: 11/15/11
 * Time: 5:00 PM
 */
public class Main {

    public static void main(String[] args) {


        Hashout testingTable = new Hashout();
        ExecutorService app = Executors.newCachedThreadPool();

        app.execute(new KeyCountThread(testingTable));
        app.execute(new KeyCountThread(testingTable));
        app.execute(new KeyCountThread(testingTable));

        app.shutdown();
    }
}