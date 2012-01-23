package employee.domxmlreader;

import java.io.File;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/11/12
 * Time: 11:11 AM
 */
public class MainDom {

    public static void main(String[] args) {
        File file = new File("Employees");
        DomXmlReader xmlDomReader = new DomXmlReader(file);

        Employee[] test =  xmlDomReader.extractEmployee();
        System.out.println(test[0].getFirstName());
        System.out.println(test[0].getLastName());
        System.out.println(test[0].getAge());
        System.out.println(test[0].getPosition());
        System.out.println(test[1].getFirstName());
        System.out.println(test[1].getLastName());
        System.out.println(test[1].getAge());
        System.out.println(test[1].getPosition());

    }
}
