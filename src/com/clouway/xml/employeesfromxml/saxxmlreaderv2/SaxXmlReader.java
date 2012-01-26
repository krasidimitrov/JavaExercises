package com.clouway.xml.employeesfromxml.saxxmlreaderv2;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

/**
 * Used to extract employees from xml file and create java Employee objects with sax
 * Created by Krasimir Dimitrov
 * Date: 1/16/12
 * Time: 3:34 PM
 */

public class SaxXmlReader extends DefaultHandler {
    private SAXParser saxParser;
    private final Resources res;

    private String tag=null;
    private List<Employee> employeeList = new LinkedList<Employee>();
    private List<Employer> employerList = new LinkedList<Employer>();
    private List<Address> addressList = new LinkedList<Address>();
    Employee employee;
    Employer employer;
    Address address;


    public SaxXmlReader(Resources resources) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            saxParser = factory.newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        res = resources;
    }

    /**
     * Used to take the tag name of every element
     */
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tag = qName;
        if (qName.equalsIgnoreCase("employee")) {
            employee = new Employee();
        }
        if (qName.equalsIgnoreCase("employer")) {
            employer = new Employer();
        }
        if (qName.equalsIgnoreCase("address")) {
            address = new Address();
        }
    }

    /**
     * Set the value of each field needed to create com.clouway.xml.employee except address and employer
     */
    public void characters(char ch[], int start, int length) throws SAXException {
        Field field = null;
        try {


            field = res.getClasses().get(tag).getDeclaredField(tag);
            field.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        try {
            assert field != null;
            if (res.getClasses().get(tag).equals(Employee.class)) {
                field.set(employee, new String(ch, start, length));
            }
            if (res.getClasses().get(tag).equals(Employer.class)) {
                field.set(employer, new String(ch, start, length));
            }
            if (res.getClasses().get(tag).equals(Address.class)) {
                field.set(address, new String(ch, start, length));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //  System.out.println(tag + ": " + new String(ch, start, length));

    }

    /**
     * Set the value of employer and address fields and take care of writing employees into list.
     */
    public void endElement(String s, String s1, String qName) throws SAXException {
        if (qName.equals("Employer")) {
            System.out.println("IN EMPLOYER");
            employerList.add(employer);
        }
        if (qName.equals("Address")) {
            System.out.println("IN ADDRESS");
            addressList.add(address);

        }
        if (qName.equals("Employee")) {
            System.out.println("IN EMPLOYEE");
            employee.setEmployers(employerList);
            employee.setAddresses(addressList);
            employeeList.add(employee);
            employerList.clear();
            addressList.clear();
        }

    }

    public void parseFile() {
        File xmlFile = new File("Employees");
        try {
            saxParser.parse(xmlFile, this);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getEmployeeList() {
        System.out.println("SDAS");
        return employeeList;
    }

}