package dk.cb.LoanGateway.controller;


import dk.cb.LoanGateway.dto.AcceptDTO;
import dk.cb.LoanGateway.dto.LoanRequestDTO;
import dk.cb.LoanGateway.dto.AcceptResponseDTO;
import dk.cb.LoanGateway.dto.BorrowerDTO;
import dk.cb.LoanGateway.kafka.BankProducer;
import dk.cb.LoanGateway.model.LoanQuote;
import dk.cb.LoanGateway.repository.LoanQuotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/loan")
public class LoanController {
    @Autowired
    private BankProducer bankProducer;

    @Autowired
    private LoanQuotesRepository repository;

    public LoanController() {
    }

    @PostMapping("/request")
    public UUID sendLoanRequest(@RequestBody int loanAmount){

        LoanRequestDTO loanRequestDTO = new LoanRequestDTO(loanAmount);
        bankProducer.sendRequest(loanRequestDTO);

        return loanRequestDTO.getBorrowerId();
    }

    @GetMapping("/{borrowerId}")
    public List<LoanQuote> viewLoanQuotes(@PathVariable UUID borrowerId){
        return repository.findByBorrowerId(borrowerId);
    }

    @PostMapping("/accept/{quoteId}/{bankId}")
    public String acceptLoanQuote(@PathVariable UUID quoteId, @PathVariable String bankId, @RequestBody BorrowerDTO borrowerDTO){

        AcceptDTO acceptDTO = new AcceptDTO(quoteId, bankId, borrowerDTO);
        bankProducer.acceptQuote(acceptDTO);
        repository.deleteByBorrowerId(borrowerDTO.getId());
        return "You will recive a confimation and contract by mail("+borrowerDTO.getEmail()+"), within the next 5 second to 2 years";
    }


}

