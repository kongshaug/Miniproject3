package dk.cb.bank1.dto;

import dk.cb.bank1.config.CommonSettings;
import dk.cb.bank1.model.Borrower;
import dk.cb.bank1.model.LoanQuote;
import dk.cb.bank1.model.Status;
import lombok.Data;

import javax.persistence.Id;
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

    public ContractDTO(LoanQuote loanQuote, Borrower borrower) {
        this.id = loanQuote.getId();
        this.borrower = new BorrowerDTO(borrower);
        this.bankId = loanQuote.getBankId();
        this.amount = loanQuote.getAmount();
        this.fee = loanQuote.getFee();
        this.duration = loanQuote.getDuration();
        this.interestRate = loanQuote.getInterestRate();
        this.status = loanQuote.getStatus();
        this.startDate = loanQuote.getStartDate();
        this.endDate = loanQuote.getEndDate();
    }


}
