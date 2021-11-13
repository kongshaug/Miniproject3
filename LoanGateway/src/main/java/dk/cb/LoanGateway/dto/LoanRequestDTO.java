package dk.cb.LoanGateway.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class LoanRequestDTO {
   private UUID borrowerId;
   private int amount;

    public LoanRequestDTO() {
    }

    public LoanRequestDTO(int amount) {
        this.borrowerId = UUID.randomUUID();
        this.amount = amount;
    }
}
