package dk.cb.contractservice.kafka;

import com.google.gson.Gson;
import dk.cb.contractservice.controller.FileController;
import dk.cb.contractservice.dto.ContractDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class ContractConsumer {
    @Autowired
    private FileController controller;
    private final Gson gson = new Gson();

    @KafkaListener(topics = "loan-contract", groupId = "banks")
    public void consumeContract(String request) throws IOException{
        ContractDTO contract = gson.fromJson(request, ContractDTO.class);
        controller.generateConfirmation(contract);
        controller.generateContract(contract);
    }
}


