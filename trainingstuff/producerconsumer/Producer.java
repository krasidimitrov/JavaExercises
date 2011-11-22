package producerconsumer;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/10/11
 * Time: 11:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class Producer implements Runnable {

    private final static Random generator = new Random();
    private final Buffer sharedLocation; // reference to shared object

    public Producer(Buffer shared) {
        sharedLocation = shared;
    }

    public void run() {
        int sum = 0;

        for (int count = 1; count <= 10; count++) {
            try {
                //sleep 0 to 3 seconds, then place value in Buffer
                Thread.sleep(generator.nextInt(3000)); // random sleep
                sharedLocation.set(count); //set value in buffer
                sum += count;
                System.out.println("produced: "+ sum);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }

        System.out.println("Producer done producing\nTerminating Producer");
    }
}
