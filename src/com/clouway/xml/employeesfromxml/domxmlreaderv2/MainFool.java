package com.clouway.xml.employeesfromxml.domxmlreaderv2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 2/3/12
 * Time: 4:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainFool {

  public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(new File("Employees"));
    NodeList nodeList = doc.getElementsByTagName("Employee");
    Foo foo = new Foo((Element) nodeList.item(1));
    Employee employee = new EmployeeModelBuilder().build(foo);
    System.out.print(employee);

  }
  
}
