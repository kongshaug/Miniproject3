package dk.cb.bank1.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AcceptDTO {

    private UUID quoteId;
    private String bankId;
    private BorrowerDTO borrower;

    public AcceptDTO() {
    }

    public AcceptDTO(UUID quoteId, String bankId, BorrowerDTO borrower) {
        this.quoteId = quoteId;
        this.bankId = bankId;
        this.borrower = borrower;
    }
}
