package dk.cb.LoanGateway.dto;

import lombok.Data;

@Data
public class AcceptResponseDTO {

    private String confirmationLetter, copyOfContract;

    public AcceptResponseDTO() {
    }

    public AcceptResponseDTO(String confirmationLetter, String copyOfContract) {
        this.confirmationLetter = confirmationLetter;
        this.copyOfContract = copyOfContract;
    }
}
