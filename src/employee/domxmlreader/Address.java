package employee.domxmlreader;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/11/12
 * Time: 9:46 AM
 */
public class Address {
    private String street;
    private String streetNo;
    private String section;
    private String city;

    public Address(AddressBuilder addressBuilder) {
        street = addressBuilder.getStreet();
        streetNo = addressBuilder.getStreet();
        section = addressBuilder.getSection();
        city = addressBuilder.getCity();
    }
}
