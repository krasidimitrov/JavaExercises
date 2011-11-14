package hello;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/8/11
 * Time: 11:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class HelloRunable implements Runnable{

    public void run(){
        System.out.println("Hello from a thread");
    }

    public static void main(String args[]){
        (new Thread(new HelloRunable())).start();
    }
}
