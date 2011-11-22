package producerconsumer;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/10/11
 * Time: 11:00 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Buffer {

    //place int value into the buffer
    public void set(int value) throws InterruptedException;

    //return int value from the buffer
    public int get() throws InterruptedException;

}
