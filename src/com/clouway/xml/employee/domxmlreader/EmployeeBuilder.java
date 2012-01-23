package com.clouway.xml.employee.domxmlreader;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/12/12
 * Time: 10:06 AM
 */
public class EmployeeBuilder implements Builder{

    private String firstName;
    private String lastName;
    private String age;
    private String position;
    private Employer[] employers;
    private Address[] addresses;

    public EmployeeBuilder(){
        firstName="";
        lastName="";
        age="";
        position="";
        employers=null;
        addresses=null;
    }

    public EmployeeBuilder withFirstName(String name){
        firstName = name;
        return this;
    }

    public EmployeeBuilder withLastName(String name){
        lastName = name;
        return this;
    }

    public EmployeeBuilder atAge(String a){
        age = a;
        return this;
    }

    public EmployeeBuilder atPosition(String pos){
        position = pos;
        return this;
    }

    public EmployeeBuilder withEmployers(Employer[] empl){
        employers = empl;
        return this;
    }

    public EmployeeBuilder withAddresses(Address[] addr){
        addresses = addr;
        return this;
    }

    public Employee buildEmployee(){
        return new Employee(this);
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

    public Employer[] getEmployers() {
        return employers;
    }

    public Address[] getAddresses() {
        return addresses;
    }
}
