package employee.domxmlreader;

import org.w3c.dom.NodeList;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/12/12
 * Time: 1:05 PM
 */
public class EmployerBuilder implements Builder{
    private String name;
    private String startDate;
    private String endDate;

    public EmployerBuilder() {
        name = "";
        startDate = "";
        endDate = "";
    }

     public EmployerBuilder withName(String name){
        this.name = name;
        return this;
    }

    public EmployerBuilder withStartDate(String date){
        startDate = date;
        return this;
    }

    public EmployerBuilder withEndDate(String date){
        endDate = date;
        return this;
    }

    public Employer buildEmployer(){
        return new Employer(this);
    }

    public String getName() {
        return name;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
