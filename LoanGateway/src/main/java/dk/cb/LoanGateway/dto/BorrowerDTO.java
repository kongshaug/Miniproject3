package dk.cb.LoanGateway.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class BorrowerDTO {

    private UUID id;
    private String firstname, lastname, cpr, email;
    private int phoneNumber;
    private AddressDTO address;

    public BorrowerDTO() {
    }

    public BorrowerDTO(UUID id, String firstname, String lastname, String cpr, String email, int phoneNumber, String street, String city, String country, int number, int zipcode ) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.cpr = cpr;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = new AddressDTO(street, city, country, number, zipcode);
    }


}
