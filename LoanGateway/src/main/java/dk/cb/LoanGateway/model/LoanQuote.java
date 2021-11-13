package dk.cb.LoanGateway.model;

import dk.cb.LoanGateway.dto.LoanQuoteDTO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class LoanQuote {

    @Id
    private UUID id;
    private UUID borrowerId;
    private String bankId;
    private int amount, fee, duration;
    private double interestRate;
    private Status status;

    public LoanQuote() { super(); }

    public LoanQuote(LoanQuoteDTO loanQuoteDTO) {
        this.id = loanQuoteDTO.getId();
        this.borrowerId = loanQuoteDTO.getBorrowerId();
        this.bankId = loanQuoteDTO.getBankId();
        this.amount = loanQuoteDTO.getAmount();
        this.fee = loanQuoteDTO.getFee();
        this.duration = loanQuoteDTO.getDuration();
        this.interestRate = loanQuoteDTO.getInterestRate();
        this.status = loanQuoteDTO.getStatus();
    }
}
