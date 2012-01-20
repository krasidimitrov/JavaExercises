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

public class SaxXmlReader extends DefaultHandler {
    private SAXParser saxParser;
    private final Resources res;

    private String tag;
    private List<Employee> employeeList = new LinkedList<Employee>();
    private List<Employer> employerList = new LinkedList<Employer>();
    private List<Address> addressList = new LinkedList<Address>();
    Employee employee;
    Employer employer;
    Address address;


    public SaxXmlReader() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            saxParser = factory.newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        res = new Resources();

    }


    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tag = qName;
        if (qName.equalsIgnoreCase("employee")) {
            employee = new Employee();
            employerList.clear();
            addressList.clear();
        }
        if (qName.equalsIgnoreCase("employer")) {
            employer = new Employer();

        }
        if (qName.equalsIgnoreCase("address")) {
            address = new Address();
        }
    }

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

    public void endElement(String s, String s1, String qName) throws SAXException {

        if (tag.equalsIgnoreCase("employer"))
            employerList.add(employer);
        if (tag.equalsIgnoreCase("address"))
            addressList.add(address);
        if (tag.equalsIgnoreCase("employee"))
            employeeList.add(employee);

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