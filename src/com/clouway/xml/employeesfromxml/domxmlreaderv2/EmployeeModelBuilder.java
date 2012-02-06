package com.clouway.xml.employeesfromxml.domxmlreaderv2;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 2/3/12
 * Time: 4:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeModelBuilder implements ModelBuilder<Employee> {
  public Employee build(Foo foo) {
    Employee employee = new EmployeeBuilder().
            withFirstName(foo.getValueByTag("firstName"))
            .withLastName(foo.getValueByTag("lastName"))
            .atAge(foo.getValueByTag("age"))
            .atPosition(foo.getValueByTag("position"))
            .withEmployers(foo.getObjectList("Employer", new EmployerModelBuilder())).withAddresses(foo.getObjectList("Address", new AddressModelBuilder())).buildEmployee();
    return employee;
  }
}
