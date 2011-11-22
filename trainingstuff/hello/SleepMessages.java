package hello;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/8/11
 * Time: 11:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class SleepMessages {
    public static void main(String[] args) throws InterruptedException{
        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        for(int i = 0; i<importantInfo.length; i++){

           try{ //pause for 4 seconds
            Thread.sleep(4000);
           } catch (InterruptedException e){ return;}//Print a message
            System.out.println(importantInfo[i]);
        }
    }
}
