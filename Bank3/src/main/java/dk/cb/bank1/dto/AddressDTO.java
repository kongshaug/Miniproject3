package dk.cb.bank1.dto;

import dk.cb.bank1.model.Address;
import lombok.Data;

@Data
public class AddressDTO {

    private String street, city, country;
    private int number, zipcode;

    public AddressDTO() {
    }

    public AddressDTO(String street, String city, String country, int number, int zipcode) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.number = number;
        this.zipcode = zipcode;
    }

    public AddressDTO(Address address) {
        this.street = address.getStreet();
        this.city = address.getCity();
        this.country = address.getCountry();
        this.number = address.getNumber();
        this.zipcode = address.getZipcode();
    }
}
