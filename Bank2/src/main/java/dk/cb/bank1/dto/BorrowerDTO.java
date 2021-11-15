package dk.cb.bank1.dto;

import dk.cb.bank1.model.Borrower;
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


    public BorrowerDTO(Borrower borrower) {
        this.id = borrower.getId();
        this.firstname = borrower.getFirstname();
        this.lastname = borrower.getLastname();
        this.cpr = borrower.getCpr();
        this.email = borrower.getEmail();
        this.phoneNumber = borrower.getPhoneNumber();
        this.address = new AddressDTO(borrower.getAddress());
    }
}
