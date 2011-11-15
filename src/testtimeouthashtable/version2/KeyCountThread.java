package testtimeouthashtable.version2;

/**
 * Created by Krasimir Dimitrov
 * Date: 11/15/11
 * Time: 4:41 PM
 */
public class KeyCountThread implements Runnable {

    Hashout sharedTable;

    public KeyCountThread(Hashout table) {
        this.sharedTable = table;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + " " + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
