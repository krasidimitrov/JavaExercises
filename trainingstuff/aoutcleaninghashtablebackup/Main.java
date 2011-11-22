package aoutcleaninghashtablebackup;

/**
 * Created by Krasimir Dimitrov
 * Date: 11/16/11
 * Time: 2:23 PM
 */
public class Main {
    public static void main(String[] args) {

    TimeoutHashtable table = new TimeoutHashtable("Begining");
    table.put("one", 1);
    table.put("two", "testtwo");

    table.getInConsole();
    }


}
