package dk.cb.bank1.controller;


import dk.cb.bank1.config.CommonSettings;
import dk.cb.bank1.dto.BorrowerDTO;
import dk.cb.bank1.dto.ContractDTO;
import dk.cb.bank1.dto.LoanRequestDTO;
import dk.cb.bank1.kafka.LoanProducer;
import dk.cb.bank1.model.Borrower;
import dk.cb.bank1.model.LoanQuote;
import dk.cb.bank1.model.Status;
import dk.cb.bank1.repository.BorrowerRepository;
import dk.cb.bank1.repository.LoanInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.time.DateUtils;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoanController {

    @Autowired
    private LoanInformationRepository loanRepository;

    @Autowired
    private BorrowerRepository borrowerRepository;

    @Autowired
    private LoanProducer producer;


    public void createLoanQuote(LoanRequestDTO loanRequestDTO) {

        LoanQuote loanQuote = new LoanQuote(loanRequestDTO);
        loanRepository.save(loanQuote);
        Optional<LoanQuote> optionalLoanQuote = loanRepository.findById(loanQuote.getId());
        producer.sendQuote(optionalLoanQuote.get());

    }

    public Optional<Borrower> createBorrower(BorrowerDTO borrowerDTO) {
        Borrower borrower = new Borrower(borrowerDTO);
        borrowerRepository.save(borrower);
        return borrowerRepository.findById(borrower.getId());
    }

    public ContractDTO acceptLoanQuote(UUID quoteId, Borrower borrower) {
        Optional<LoanQuote> optionalLoanQuote = loanRepository.findById(quoteId);

        if (optionalLoanQuote.isPresent() && optionalLoanQuote.get().getBorrowerId().equals(borrower.getId())) {
            LoanQuote loanQuote = optionalLoanQuote.get();
            loanQuote.setStatus(Status.ACCEPTED);

            Date today = new Date();
            loanQuote.setStartDate(CommonSettings.formatter.format(today));
            loanQuote.setEndDate(CommonSettings.formatter.format(DateUtils.addMonths(today, loanQuote.getDuration())));

            loanQuote = loanRepository.save(loanQuote);

            return new ContractDTO(loanQuote, borrower);
        }
        return  null;
    }

    public void declineLoanQuote(UUID borrowerId) {
        Optional<LoanQuote> optionalLoanQuote = loanRepository.findByBorrowerId(borrowerId);
        if (optionalLoanQuote.isPresent()) {
            LoanQuote loanQuote = optionalLoanQuote.get();
            loanQuote.setStatus(Status.DECLINED);
            loanRepository.save(loanQuote);
        }
    }

    public void sendContractInformation(ContractDTO contract) {
        if(contract != null) {
            producer.sendContract(contract);
        }
    }
}
