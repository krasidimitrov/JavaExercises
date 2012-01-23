package com.clouway.xml.employee.saxxmlreader;

import java.util.List;

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
    private List<Employer> employers;
    private List<Address> adresses;

    public Employee(){

    }

    public void setEmployers(List<Employer> employers) {
        this.employers = employers;
    }

    public void setAdresses(List<Address> adresses) {
        this.adresses = adresses;
    }
}
