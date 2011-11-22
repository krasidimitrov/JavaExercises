package testtimeouthashtable.version2;

/**
 * Created by Krasimir Dimitrov
 * Date: 11/15/11
 * Time: 5:00 PM
 */
public class Main {

    public static void main(String[] args) {

//
//        Hashout testingTable = new Hashout();
//        ExecutorService app = Executors.newCachedThreadPool();
//
//        app.execute(new KeyCountThread(testingTable));
//        app.execute(new KeyCountThread(testingTable));
//        app.execute(new KeyCountThread(testingTable));
//
//        app.shutdown();

       Hashout autocleaningTable = new Hashout();
       autocleaningTable.put("one", "testone");
        System.out.println(autocleaningTable.getElementByKey("one"));
        autocleaningTable.put("one", "testoneeeeeeeee");
                                                 System.out.println(autocleaningTable.getElementByKey("one"));
       autocleaningTable.put("two", "testtwo");

        autocleaningTable.get();
    }
}
