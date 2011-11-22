package task2;


/**
 * Created by Krasimir Dimitrov
 * Date: 11/22/11
 * Time: 1:30 PM
 */
public class Main {

    public static void main(String[] args) {

    CounterClass sharedCounter = new CounterClass();

        ThreadCounterAgain countObject1 = new ThreadCounterAgain(100, sharedCounter);
        ThreadCounterAgain countObject2 = new ThreadCounterAgain(10, sharedCounter);

    Thread thread1 = new Thread(countObject1);
    Thread thread2 = new Thread(countObject2);

        countObject1.setReference(thread2);
        countObject2.setReference(thread1);



        thread1.start();
        thread2.start();
}  }
