package dk.cb.contractservice.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ContractDTO {

    private UUID id;
    private BorrowerDTO borrower;
    private String bankId, startDate, endDate;
    private int amount, fee, duration;
    private double interestRate;
    private Status status;

    public ContractDTO() {}

}
