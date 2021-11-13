package dk.cb.contractservice.dto;

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

}
