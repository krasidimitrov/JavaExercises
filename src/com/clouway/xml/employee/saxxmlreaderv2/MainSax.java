package com.clouway.xml.employee.saxxmlreaderv2;

import java.util.List;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/16/12
 * Time: 3:31 PM
 */
public class MainSax {
    public static void main(String[] args) {
        SaxXmlReader saxParser= new SaxXmlReader(new Resources());
        saxParser.parseFile();
        List<Employee> employees =  saxParser.getEmployeeList();
        System.out.println(employees.get(0).getFirstName());
        System.out.println(employees.get(0).getLastName());
        System.out.println(employees.get(0).getAge());
        System.out.println(employees.get(0).getPosition());
        System.out.println(employees.get(1).getFirstName());

    }
}
