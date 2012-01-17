package employee.saxxmlreader;

import employee.Employee;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/16/12
 * Time: 3:31 PM
 */
public class MainSax {
    public static void main(String[] args) {
        SaxXmlReader test= new SaxXmlReader();
        test.parseFile();
        Employee[] testEmployees = test.getEmployees();
        System.out.println(testEmployees[0].getFirstName());
        System.out.println(testEmployees[0].getLastName());
        System.out.println(testEmployees[0].getAge());
        System.out.println(testEmployees[0].getPosition());
        System.out.println("\n");
              System.out.println(testEmployees[1].getFirstName());
        System.out.println(testEmployees[1].getLastName());
        System.out.println(testEmployees[1].getAge());
        System.out.println(testEmployees[1].getPosition());

    }
}
