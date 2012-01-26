package employee.saxxmlreader;



import java.util.List;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/16/12
 * Time: 3:31 PM
 */
public class MainSax {
    public static void main(String[] args) {
        SaxXmlReader test= new SaxXmlReader();
        test.parseFile();
        List<Employee> testEmployees = test.getEmployees();


    }
}
