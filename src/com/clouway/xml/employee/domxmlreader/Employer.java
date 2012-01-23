package com.clouway.xml.employee.domxmlreader;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/11/12
 * Time: 9:45 AM
 */
public class Employer {

    private String name;
    private String startDate;
    private String endDate;

    public Employer(EmployerBuilder employer){
       name = employer.getName();
       startDate = employer.getStartDate();
       endDate = employer.getEndDate();
    }
}
