package hello;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/8/11
 * Time: 11:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class HelloThread extends Thread {

    public void run(){
        System.out.println("Hello from a thread");
    }

    public static void main(String[] args) {
        (new HelloThread()).start();
    }
}
