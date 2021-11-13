package dk.cb.contractservice.dto;

import lombok.Data;

@Data
public class AddressDTO {

    private String street, city, country;
    private int number, zipcode;

    public AddressDTO() {
    }

}
