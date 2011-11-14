package producerconsumer;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/10/11
 * Time: 11:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class Consumer implements Runnable {

    private final static Random generator = new Random();
    private final Buffer sharedLocation;

    public Consumer(Buffer shared) {
        sharedLocation = shared;
    }

    //read sharedLocation's value 10 times and sum the values
    public void run() {
        int sum = 0;

        for (int count = 1; count <= 10; count++) {
            //sleep 0 to 3 seconds, read value from buffer and add to sum
            try {
                Thread.sleep(generator.nextInt(3000));
                sum += sharedLocation.get();
                System.out.println("comsumed: "+sum);
                //if lines 26 or 27 get interrupted, print stack trace
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }

        System.out.printf("\n%s %d\n%s\n", "Consumer read values totaling", sum, "Terminating Consumer");
    }
}
