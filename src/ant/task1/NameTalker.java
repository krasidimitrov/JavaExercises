package ant.task1;


import org.apache.log4j.Logger;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/23/12
 * Time: 5:20 PM
 */
public class NameTalker {

    public void hello(String name){
        System.out.println("Hello "+name);
        Logger logger = Logger.getLogger("pesho");
        logger.info("jjjjj");
    }

    public int getAge(String name){
        if(name.equalsIgnoreCase("krasi")){
            return 22;
        }
        else {
            return 0;
        }
    }
}
