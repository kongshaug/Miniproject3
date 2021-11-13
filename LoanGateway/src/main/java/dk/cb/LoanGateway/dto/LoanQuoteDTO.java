package dk.cb.LoanGateway.dto;

import dk.cb.LoanGateway.model.Status;
import lombok.Data;
import java.util.UUID;

@Data
public class LoanQuoteDTO {

    private UUID id, borrowerId;
    private String bankId, startDate, endDate;
    private int amount, fee, duration;
    private double interestRate;
    private Status status;

    public LoanQuoteDTO() { super(); }

}
