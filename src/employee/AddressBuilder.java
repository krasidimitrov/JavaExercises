package employee;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/12/12
 * Time: 1:24 PM
 */
public class AddressBuilder implements Builder{

    private String street;
    private String streetNo;
    private String section;
    private String city;

    public AddressBuilder(){
        street = "";
        streetNo = "";
        section = "";
        city = "";
    }

    public AddressBuilder withStreet(String street){
        this.street = street;
        return this;
    }

    public AddressBuilder withStreetNo(String streetNo){
        this.streetNo = streetNo;
        return this;
    }

    public AddressBuilder withSection(String section){
        this.section = section;
        return this;
    }

    public AddressBuilder withCity(String city){
        this.city = city;
        return this;
    }

    public Address buildAddress(){
        return new Address(this);
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public String getSection() {
        return section;
    }

    public String getCity() {
        return city;
    }
}
