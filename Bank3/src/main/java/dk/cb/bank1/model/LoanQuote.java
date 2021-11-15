package dk.cb.bank1.model;

import dk.cb.bank1.config.CommonSettings;
import dk.cb.bank1.dto.LoanRequestDTO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;
@Entity
@Data
public class LoanQuote {

    @Id
    private UUID id;
    private UUID borrowerId;
    private String bankId, startDate, endDate;
    private int amount, fee, duration;
    private double interestRate;
    private Status status;

    public LoanQuote() { super(); }

    public LoanQuote(LoanRequestDTO loanRequestDTO) {
        this.id = UUID.randomUUID();
        this.borrowerId = loanRequestDTO.getBorrowerId();
        this.bankId = CommonSettings.bankId;
        this.amount = loanRequestDTO.getAmount();
        this.fee = CommonSettings.fee;
        this.duration = CommonSettings.duration;
        this.interestRate = CommonSettings.interestRate;
        this.status = Status.PENDING;
        this.startDate = "";
        this.endDate = "";
    }


}
