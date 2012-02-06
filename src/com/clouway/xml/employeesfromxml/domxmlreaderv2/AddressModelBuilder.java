package com.clouway.xml.employeesfromxml.domxmlreaderv2;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 2/3/12
 * Time: 4:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddressModelBuilder implements ModelBuilder<Address>{
  public Address build(Foo foo) {
    Address address = new AddressBuilder().withCity(foo.getValueByTag("city"))
           .withStreet("street").
            withStreetNo("streetNo")
           .withSection("section").buildAddress();
    return  address;


  }
}
