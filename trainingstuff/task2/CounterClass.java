package task2;

/**
 * Created by Krasimir Dimitrov
 * Date: 11/22/11
 * Time: 1:30 PM
 */
public class CounterClass {

    public int count(int maxCount) {
        int count = 0;
        while (true) {
            try {
                count++;
                Thread.sleep(200);
                System.out.println(Thread.currentThread().getName() + " " + count);
                if (count == maxCount) {
                    Thread.currentThread().interrupt();
                            return count;
                }
            } catch (InterruptedException e) {

            }
        }

    }
}
