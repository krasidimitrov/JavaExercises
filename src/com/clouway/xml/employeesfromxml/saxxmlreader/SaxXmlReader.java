package employee.saxxmlreader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SaxXmlReader extends DefaultHandler {
    private SAXParser saxParser;
    private final Resources res;

    private String tag;
    private List<Employee> employees = new LinkedList<Employee>();
    private List<Employer> employers = new LinkedList<Employer>();
    private List<Address> addresses = new LinkedList<Address>();
    private EmployeeBuilder employeeBuilder = new EmployeeBuilder();
    private EmployerBuilder employerBuilder = new EmployerBuilder();
    private AddressBuilder addressBuilder = new AddressBuilder();
    private Map<Class, Builder> buildersMap = new HashMap<Class, Builder>();


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
        buildersMap.put(EmployeeBuilder.class, employeeBuilder);
        buildersMap.put(EmployerBuilder.class, employerBuilder);
        buildersMap.put(AddressBuilder.class, addressBuilder);

    }


    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tag = qName;
    }

    public void characters(char ch[], int start, int length) throws SAXException {
        // Class class = res.getClasses().get(tag);
        Method method = null;
        try {
            method = res.getClasses().get(tag).getDeclaredMethod(res.getMethods().get(tag), String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            if (method != null) {
                method.invoke(buildersMap.get(res.getClasses().get(tag)), new String(ch, start, length));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //  System.out.println(tag + ": " + new String(ch, start, length));

    }

    public void endElement(String s, String s1, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("Employer")) {
            employers.add(employerBuilder.buildEmployer());
        }
        if (qName.equalsIgnoreCase("Address")) {
            addresses.add(addressBuilder.buildAddress());
        }
        if (qName.equalsIgnoreCase("Employee")) {
            employeeBuilder.withEmployers(employers).withAddresses(addresses);
            employees.add(employeeBuilder.buildEmployee());
            employers.clear();
            addresses.clear();
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

    public List<Employee> getEmployees() {
        return employees;
    }
}