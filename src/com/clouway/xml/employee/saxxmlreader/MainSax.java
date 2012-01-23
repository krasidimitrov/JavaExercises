package com.clouway.xml.employee.saxxmlreader;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/16/12
 * Time: 3:31 PM
 */
public class MainSax {
    public static void main(String[] args) {
        SaxXmlReader saxParser= new SaxXmlReader(new Resources());
        saxParser.parseFile();
//        List<Employee> testEmployees = saxParser.getEmployeeList();
    }
}
