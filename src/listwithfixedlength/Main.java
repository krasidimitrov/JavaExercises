package listwithfixedlength;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/14/11
 * Time: 2:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {


    ObjectList list = new ObjectList(3);

    ExecutorService app = Executors.newCachedThreadPool();

//    app.execute(new ThreadRemove(list));
//    app.execute(new ThreadAdd(list));
//    app.execute(new ThreadAdd(list));
//    app.execute(new ThreadAdd(list));
//    app.execute(new ThreadAdd(list));
//
//
//
//    app.shutdown();
        new Thread(new ThreadAdd(list)).start();
        new Thread(new ThreadAdd(list)).start();
        new Thread(new ThreadAdd(list)).start();
        new Thread(new ThreadAdd(list)).start();
        new Thread(new ThreadRemove(list)).start();

    }
}
