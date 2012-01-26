package com.clouway.xml.employeesfromxml.domxmlreader;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/11/12
 * Time: 9:44 AM
 */
public class Employee {
    private String firstName;
    private String lastName;
    private String age;
    private String position;
    private Employer[] employers;
    private Address[] adresses;

    public Employee(EmployeeBuilder employeeBuilder){
        firstName = employeeBuilder.getFirstName();
        lastName = employeeBuilder.getLastName();
        age = employeeBuilder.getAge();
        position = employeeBuilder.getPosition();
        employers = employeeBuilder.getEmployers();
        adresses = employeeBuilder.getAddresses();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }
}
