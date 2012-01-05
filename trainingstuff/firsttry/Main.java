package firsttry;

import com.clouway.jdbc.triplog.Connect;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/3/12
 * Time: 1:49 PM
 */
public class Main {
    public static void main(String[] args) {
        Connect connect = new Connect();


        Foo foo = new Foo();
        foo.setConnect(connect.connectToDatabase("kpackapgo",""));
        foo.createTable("programtable2");
    }
}
