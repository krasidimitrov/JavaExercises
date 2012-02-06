package com.clouway.xml.employeesfromxml.domxmlreaderv2;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 2/3/12
 * Time: 4:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class EmployerModelBuilder implements ModelBuilder<Employer>{
  public Employer build(Foo foo) {
    Employer employer = new EmployerBuilder().withName(foo.getValueByTag("name")).withStartDate(foo.getValueByTag("startDate")).withEndDate(foo.getValueByTag("endDate")).buildEmployer();
    return employer;
  }
}
