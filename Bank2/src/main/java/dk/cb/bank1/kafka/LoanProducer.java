package dk.cb.bank1.kafka;

import com.google.gson.Gson;
import dk.cb.bank1.dto.ContractDTO;
import dk.cb.bank1.model.LoanQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LoanProducer
{
    private final Gson gson = new Gson();
    private static final String TOPIC = "loan-quotes";
    private static final String contractTOPIC = "loan-contract";

    @Autowired
    private KafkaTemplate<String, String> requestTemplate;

    public void sendQuote(LoanQuote loanQuote)
    {
        requestTemplate.send(TOPIC, gson.toJson(loanQuote));

        requestTemplate.flush();
    }
    public void sendContract(ContractDTO contract)
    {
        requestTemplate.send(contractTOPIC, gson.toJson(contract));

        requestTemplate.flush();
    }



}
