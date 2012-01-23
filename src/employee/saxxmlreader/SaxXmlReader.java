package employee.saxxmlreader;

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

    private String tag;
    private List<Employee> employeeList = new LinkedList<Employee>();
    private  List<Employer> employerList = new LinkedList<Employer>();
    private List<Address> addressList = new LinkedList<Address>();
    Employee employee = new Employee();
    Employer employer = new Employer();
    Address address = new Address();


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
     *  Used to take the tag name of every element
     */
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tag = qName;
    }

    /**
     *  Set the value of each field needed to create employee except address and employer
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
     *  Set the value of employer and address fields and take care of writing employees into list.
     */
    public void endElement(String s, String s1, String qName) throws SAXException {
        if (tag.equalsIgnoreCase("employer"))
            employerList.add(employer);
            employer = new Employer();
        if (tag.equalsIgnoreCase("address"))
            addressList.add(address);
            address = new Address();
        if (tag.equalsIgnoreCase("employee"))
            employeeList.add(employee);
            employee = new Employee();
            employerList.clear();
            addressList.clear();

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
        return employeeList;
    }

}