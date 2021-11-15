package dk.cb.bank1.kafka;

import com.google.gson.Gson;
import dk.cb.bank1.config.CommonSettings;
import dk.cb.bank1.controller.LoanController;
import dk.cb.bank1.dto.AcceptDTO;
import dk.cb.bank1.dto.ContractDTO;
import dk.cb.bank1.dto.LoanRequestDTO;
import dk.cb.bank1.model.Borrower;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Optional;


@Service
public class LoanConsumer {

    private final Gson gson = new Gson();

    @Autowired
    private LoanController controller;

        @KafkaListener(topics = "loan-request", groupId = "banks")
        public void consumeRequest(String request) throws IOException
        {
            LoanRequestDTO loanRequestDTO = gson.fromJson(request, LoanRequestDTO.class);
            controller.createLoanQuote(loanRequestDTO);
        }

        @KafkaListener(topics = "loan-accept", groupId = "banks")
        public void consumeAccept(String accept) throws IOException
        {
            AcceptDTO acceptDTO = gson.fromJson(accept, AcceptDTO.class);

            if(CommonSettings.bankId.equals(acceptDTO.getBankId())) {
                Optional<Borrower> optionalBorrower = controller.createBorrower(acceptDTO.getBorrower());
                ContractDTO contract = controller.acceptLoanQuote(acceptDTO.getQuoteId(), optionalBorrower.get());
                controller.sendContractInformation(contract);
            }
            else{
                controller.declineLoanQuote(acceptDTO.getBorrower().getId());
            }

        }
    }

