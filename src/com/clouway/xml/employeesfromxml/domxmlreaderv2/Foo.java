package com.clouway.xml.employeesfromxml.domxmlreaderv2;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 2/3/12
 * Time: 4:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class Foo {
  private Element element;

  public Foo(Element ele) {
    element = ele;
  }

  public String getValueByTag(String tag) {
    NodeList nodeList = element.getElementsByTagName(tag);
    Node node = nodeList.item(0);
    return node.getFirstChild().getNodeValue().trim();
  }

  public <T> List<T> getObjectList(String tagName, ModelBuilder<T> tCreatesObjectsModel) {
    List<T> typeObjects = new ArrayList<T>();
    NodeList nodeList = element.getElementsByTagName(tagName);

    for (int i = 0; i < nodeList.getLength(); i++) {
      typeObjects.add(tCreatesObjectsModel.build(this));
    }

    return typeObjects;
  }
}
