package listwithfixedlength;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/14/11
 * Time: 2:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreadRemove implements Runnable{

     ObjectList list;

    public ThreadRemove(ObjectList list){
        this.list = list;
    }

    public void run(){
        list.remove();
    }
}
