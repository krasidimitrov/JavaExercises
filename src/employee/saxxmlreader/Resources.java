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
    private Map<String, Class> classesList = new HashMap<String, Class>();

    public Resources() {

        classesList.put("firstName", Employee.class);
        classesList.put("lastName", Employee.class);
        classesList.put("age", Employee.class);
        classesList.put("position", Employee.class);
        classesList.put("name", Employer.class);
        classesList.put("startDate", Employer.class);
        classesList.put("endDate", Employer.class);
        classesList.put("street", Address.class);
        classesList.put("streetNo", Address.class);
        classesList.put("section", Address.class);
        classesList.put("city", Address.class);
    }


    public Map<String, Class> getClasses() {
        return classesList;
    }
}
