package dk.cb.LoanGateway.kafka;

import com.google.gson.Gson;
import dk.cb.LoanGateway.dto.LoanQuoteDTO;
import dk.cb.LoanGateway.model.LoanQuote;
import dk.cb.LoanGateway.repository.LoanQuotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class BankConsumer {

    private final Gson gson = new Gson();

    @Autowired
    private LoanQuotesRepository repository;

    @KafkaListener(topics = "loan-quotes", groupId = "banks")
    public void consumeLoanQuotes(String quote) throws IOException
    {
        LoanQuoteDTO loanQuoteDTO = gson.fromJson(quote, LoanQuoteDTO.class);
        LoanQuote loanQuote = new LoanQuote(loanQuoteDTO);
        repository.save(loanQuote);

        System.out.println("QUOTE CONSUMED: ");
        System.out.println(loanQuoteDTO);


    }

}
