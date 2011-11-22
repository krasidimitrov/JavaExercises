package arraywiththreads;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/10/11
 * Time: 9:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class ArrayWriter implements Runnable {

    private final SimpleArray sharedSimpleArray;
    private final int startValue;

    public ArrayWriter(int value, SimpleArray array) {
        startValue = value;
        sharedSimpleArray = array;
    }

    public void run() {
        for (int i = startValue; i < startValue + 3; i++) {
            sharedSimpleArray.add(i);// add an element to the shared array
        }
    }
}
