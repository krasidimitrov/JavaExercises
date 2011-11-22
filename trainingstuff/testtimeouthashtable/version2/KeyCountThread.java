package testtimeouthashtable.version2;

/**
 * Created by Krasimir Dimitrov
 * Date: 11/15/11
 * Time: 4:41 PM
 */
public class KeyCountThread implements Runnable {

    Hashout sharedTable;
    private int counter = 0;
    private String keyFollowed;

   public KeyCountThread(String key){
       this.keyFollowed = key;

    }

    public void run() {
        for (;counter < 10; counter++) {
            try {

                System.out.println(Thread.currentThread().getName() + " " + counter);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
        Hashout.remove(keyFollowed);
    }

    public String getKeyFollowed() {
        return keyFollowed;
    }

    public void setKeyFollowed(String keyFollowed) {
        this.keyFollowed = keyFollowed;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
