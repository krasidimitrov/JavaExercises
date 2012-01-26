package employee.saxxmlreader;

import java.util.HashMap;
import java.util.Map;

/**
 * Connect all methods and builders with appropriate tags
 * Created by Krasimir Dimitrov
 * Date: 1/16/12
 * Time: 3:34 PM
 */
public class Resources {
    private Map<String, String> methodsList = new HashMap<String, String>();
    private Map<String, Class> classesList = new HashMap<String, Class>();

    public Resources() {
        methodsList.put("firstName", "withFirstName");
        methodsList.put("lastName", "withLastName");
        methodsList.put("age", "atAge");
        methodsList.put("position", "atPosition");
        methodsList.put("name", "withName");
        methodsList.put("startDate", "withStartDate");
        methodsList.put("endDate", "withEndDate");
        methodsList.put("street", "withStreet");
        methodsList.put("streetNo", "withStreetNo");
        methodsList.put("section", "withSection");
        methodsList.put("city", "withCity");

        classesList.put("firstName", EmployeeBuilder.class);
        classesList.put("lastName", EmployeeBuilder.class);
        classesList.put("age", EmployeeBuilder.class);
        classesList.put("position", EmployeeBuilder.class);
        classesList.put("name", EmployerBuilder.class);
        classesList.put("startDate", EmployerBuilder.class);
        classesList.put("endDate", EmployerBuilder.class);
        classesList.put("street", AddressBuilder.class);
        classesList.put("streetNo", AddressBuilder.class);
        classesList.put("section", AddressBuilder.class);
        classesList.put("city", AddressBuilder.class);
    }

    public Map<String, String> getMethods() {
        return methodsList;
    }

    public Map<String, Class> getClasses() {
        return classesList;
    }
}
