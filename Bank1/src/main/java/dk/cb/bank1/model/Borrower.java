package dk.cb.bank1.model;

import dk.cb.bank1.dto.AddressDTO;
import dk.cb.bank1.dto.BorrowerDTO;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Borrower {

    @Id
    private UUID id;
    private String firstname, lastname, cpr, email;
    private int phoneNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address", referencedColumnName = "id")
    private Address address;

    public Borrower() {  super();  }

    public Borrower(BorrowerDTO borrower) {
        this.id = borrower.getId();
        this.firstname = borrower.getFirstname();
        this.lastname = borrower.getLastname();
        this.cpr = borrower.getCpr();
        this.email = borrower.getEmail();
        this.phoneNumber = borrower.getPhoneNumber();
        this.address = new Address(borrower.getAddress());
    }

}
