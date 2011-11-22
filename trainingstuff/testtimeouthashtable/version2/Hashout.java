package testtimeouthashtable.version2;

import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by Krasimir Dimitrov
 * Date: 11/15/11
 * Time: 1:10 PM
 */
public class Hashout {
    private static Hashtable<String, String> autoCleaningTable = new Hashtable<String, String>();
    Thread countThread;
    KeyCountThread keyCountThread;
    private static Hashtable<String, KeyCountThread> threadReferencesTable = new Hashtable<String, KeyCountThread>();
    Scanner in = new Scanner(System.in);

    public void put(String key, String value) {
        if (autoCleaningTable.containsKey(key)) {
            autoCleaningTable.put(key, value);
        } else {
            countThread = new Thread(keyCountThread = new KeyCountThread(key));
            threadReferencesTable.put(key, keyCountThread);
            countThread.start();
            autoCleaningTable.put(key, value);
        }
    }

    public String getElementByKey(String key) {
        if (autoCleaningTable.containsKey(key)) {
            keyCountThread.getKeyFollowed();
            return autoCleaningTable.get(key);
        } else {
            return null;
        }

    }


    public void get() {
        String checker;
        while (!(checker = in.next()).equals("quit")) {
            if (autoCleaningTable.containsKey(checker)) {
                System.out.println(keyCountThread.getKeyFollowed());
                threadReferencesTable.get(checker).setCounter(0);

            }
        }
    }

    public static void remove(String key) {
        autoCleaningTable.remove(key);
    }

}
