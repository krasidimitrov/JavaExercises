package employee.domxmlreader;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Used to extract employees from xml file and create java Employee objects with dom
 * Created by Krasimir Dimitrov
 * Date: 1/11/12
 * Time: 9:53 AM
 */
public class DomXmlReader {
    private Document doc;

    public DomXmlReader(File file) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(file);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        doc.getDocumentElement().normalize();
    }

    /**
     * Extract all employees from the xml file
     * @return an array with all employees from the xml file
     */
    public Employee[] extractEmployee() {
        EmployeeBuilder employeeBuilder = new EmployeeBuilder();
        NodeList employeeList = doc.getElementsByTagName("Employee");
        Employee[] employees = new Employee[employeeList.getLength()];
        for (int i = 0; i < employeeList.getLength(); i++) {
            Node employeeNode = employeeList.item(i);
            System.out.println("Employee index " + i);
            Element employeeElement = (Element) employeeNode;


            employeeBuilder.withFirstName(getTagValue("firstName", employeeElement));
            employeeBuilder.withLastName(getTagValue("lastName", employeeElement));
            employeeBuilder.atAge(getTagValue("age", employeeElement));
            employeeBuilder.atPosition(getTagValue("position", employeeElement));


            NodeList employerList = employeeElement.getElementsByTagName("Employer");
            employeeBuilder.withEmployers(extractEmployers(employerList));

            NodeList addressList = employeeElement.getElementsByTagName("Address");
            employeeBuilder.withAddresses(extractAddress(addressList));

            employees[i] = employeeBuilder.buildEmployee();
        }
        return employees;
    }

    /**
     * Extract all employers for a given employee
     * @param nodeList the Employee taken from the xml file as a nodeList
     * @return array with all employers for the given employee
     */
    private Employer[] extractEmployers(NodeList nodeList) {
        Employer[] employersList = new Employer[nodeList.getLength()];
        EmployerBuilder employer = new EmployerBuilder();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node employerNode = nodeList.item(i);
            Element employerElement = (Element) employerNode;
            employer.withName(getTagValue("name", employerElement));
            employer.withStartDate(getTagValue("startDate", employerElement));
            employer.withEndDate(getTagValue("endDate", employerElement));
            employersList[i] = employer.buildEmployer();
        }
        return employersList;
    }

    /**
     * Extract all addresses for a given employee
     * @param nodeList the Employee taken from the xml file as a nodeList
     * @return  array with all addresses for the given employee
     */
    private Address[] extractAddress(NodeList nodeList) {
        Address[] addressesList = new Address[nodeList.getLength()];
        AddressBuilder address = new AddressBuilder();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node addressNode = nodeList.item(i);
            Element addressElement = (Element) addressNode;
            address.withCity(getTagValue("street", addressElement));
            address.withStreetNo(getTagValue("streetNo", addressElement));
            address.withSection(getTagValue("section", addressElement));
            address.withCity(getTagValue("city", addressElement));
            addressesList[i] = address.buildAddress();
        }
        return addressesList;
    }
    

    /**
     * Return the value of text node for a given element node
     * @param sTag the name of the tag surrounding the text we want to take
     * @param eElement the element from which we are getting the value
     * @return  the value for the given element for the given tag
     */
    private static String getTagValue(String sTag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();

        Node nValue = (Node) nlList.item(0);

        return nValue.getNodeValue();
    }

//                NodeList childs = employeeElement.getChildNodes();
//                for (int i = 0; i < childs.getLength(); i++) {
//                    if (childs.item(i).getNodeType() == Node.ELEMENT_NODE)
//                        System.out.println(childs.item(i).getNodeName());
//                }

}
