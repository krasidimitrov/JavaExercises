package com.clouway.xml.employeesfromxml.domxmlreaderv2;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 2/3/12
 * Time: 4:05 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ModelBuilder <T> {
  public T build (Foo foo);
}
