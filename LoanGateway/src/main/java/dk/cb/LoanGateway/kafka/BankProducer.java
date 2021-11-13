package dk.cb.LoanGateway.kafka;

import com.google.gson.Gson;
import dk.cb.LoanGateway.dto.AcceptDTO;
import dk.cb.LoanGateway.dto.LoanRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BankProducer
{
    private final Gson gson = new Gson();
    private static final String REQUEST_TOPIC = "loan-request";
    private static final String ACCEPT_TOPIC = "loan-accept";
    //private static Logger logger = LoggerFactory.getLogger(ProducerService.class);
    
    @Autowired
    private KafkaTemplate<String, String> requestTemplate;
    @Autowired
    private KafkaTemplate<String, String> acceptTemplate;
    
    public void sendRequest(LoanRequestDTO loanrequest)
    {
        requestTemplate.send(REQUEST_TOPIC, gson.toJson(loanrequest));

        requestTemplate.flush();
    }

    public void acceptQuote(AcceptDTO acceptDTO) {
        acceptTemplate.send(ACCEPT_TOPIC, gson.toJson(acceptDTO));

        acceptTemplate.flush();
    }
}