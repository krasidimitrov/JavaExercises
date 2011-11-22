package aoutcleaninghashtablebackup;


import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by Krasimir Dimitrov
 * Date: 11/16/11
 * Time: 2:17 PM
 */
public class TimeoutHashtable implements Runnable {

    private Hashtable<String, Object> autoCleaningTable = new Hashtable<String, Object>();
    private Hashtable<String, TimeoutHashtable> threadReferencesTable = new Hashtable<String, TimeoutHashtable>();
    private TimeoutHashtable keyFollower;
    private String keyFollowed;
    private int timeCounter = 0;
    private Scanner in = new Scanner(System.in);

    public TimeoutHashtable(String key) {
        this.keyFollowed = key;
    }

    /**
     * Put an element in the hashtable and starts a thread that follow this key
     *
     * @param key    the key that we are going to put in the hashtable
     * @param object the object that we put in the hashtable
     */
    public void put(String key, Object object) {
        if (autoCleaningTable.containsKey(key)) {
            autoCleaningTable.put(key, object);
            threadReferencesTable.get(key).timeCounter = 0;

        } else {
            Thread thread = new Thread(keyFollower = new TimeoutHashtable(key));
            threadReferencesTable.put(key, keyFollower);
            thread.start();
            autoCleaningTable.put(key, object);
        }
    }

    /**
     * get an Object from the hashtable using his key
     *
     * @param key the key of  the Object we want to get
     * @return the object that we get form the hashtable
     */
    public Object get(String key) {
        if (autoCleaningTable.containsKey(key)) {
            threadReferencesTable.get(key).timeCounter = 0;
            return threadReferencesTable.get(key);

        } else {
            return null;
        }
    }

    /**
     * Get an object from the table when we input a key from the keyboard
     */
    public void getInConsole() {
        String checker;
        while (!(checker = in.next()).equals("quit")) {
            System.out.println(get(checker));
        }
    }

    public void run() {
        for (; timeCounter < 10; timeCounter++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + timeCounter);
        }
        System.out.println(autoCleaningTable.get(keyFollowed));
        autoCleaningTable.remove(keyFollowed);
        System.out.println(autoCleaningTable.get(keyFollowed));

    }
}
