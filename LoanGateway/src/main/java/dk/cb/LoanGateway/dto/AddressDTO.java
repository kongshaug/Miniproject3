package dk.cb.LoanGateway.dto;

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
}
