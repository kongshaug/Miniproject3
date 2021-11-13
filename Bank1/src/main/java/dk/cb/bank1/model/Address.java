package dk.cb.bank1.model;

import dk.cb.bank1.dto.AddressDTO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

@Data
@Entity
public class Address {
    @Id
    private UUID id;
    private String street, city, country;
    private int number, zipcode;

    public Address() {  super();  }

    public Address(AddressDTO address) {
        this.id = UUID.randomUUID();
        this.street = address.getStreet();
        this.city = address.getCity();
        this.country = address.getCountry();
        this.number = address.getNumber();
        this.zipcode = address.getZipcode();
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", number=" + number +
                ", zipcode=" + zipcode +
                '}';
    }
}
