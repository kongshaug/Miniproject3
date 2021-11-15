package dk.cb.bank1.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class LoanRequestDTO {
   private UUID borrowerId;
   private int amount;

    public LoanRequestDTO() {
    }

    public LoanRequestDTO(int amount, UUID borrowerId) {
        this.borrowerId = borrowerId;
        this.amount = amount;
    }
}
