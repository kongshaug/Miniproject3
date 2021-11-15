package dk.cb.contractservice.controller;

import dk.cb.contractservice.client.RestNamesClient;
import dk.cb.contractservice.dto.ContractDTO;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.*;

@Service
public class FileController {

    @Autowired
    private RestNamesClient client;

    public void generateContract(ContractDTO contract) {
        // Source directory
        String sourceDirectory = "./src/main/java/dk/cb/contractservice/emails/contracts/";

        // Create the velocity engine
        VelocityEngine ve = new VelocityEngine();

        ve.setProperty( "resource.loader", "file");
        ve.setProperty( "file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
        ve.setProperty( "file.resource.loader.path", sourceDirectory);
        ve.setProperty( "file.resource.loader.cache", true);
        ve.setProperty( "file.resource.loader.modificationCheckInterval", "2");
        ve.init();

        // Get the template
        Template t = ve.getTemplate( "contractTemplate.vm" );

        // Create the
        VelocityContext context = new VelocityContext();
        context.put("startDate", contract.getStartDate());
        context.put("endDate", contract.getEndDate());
        context.put("firstname", contract.getBorrower().getFirstname());
        context.put("lastname", contract.getBorrower().getLastname());
        context.put("street", contract.getBorrower().getAddress().getStreet());
        context.put("number", contract.getBorrower().getAddress().getNumber());
        context.put("zipcode", contract.getBorrower().getAddress().getZipcode());
        context.put("city", contract.getBorrower().getAddress().getCity());
        context.put("bankId", contract.getBankId());
        context.put("amount", contract.getAmount());
        context.put("duration", contract.getDuration());
        context.put("interestRate", contract.getInterestRate());
        context.put("fee", contract.getFee());

        try {
            // Create the output file
            Writer out = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(
                                    new File( sourceDirectory + "contract_" + contract.getId() + ".txt")),
                            "UTF8") );
            t.merge( context, out);

            out.close();
        } catch ( Exception e ){
            e.printStackTrace();
        }
    }

    public void generateConfirmation(ContractDTO contract) throws IOException {
        // Source directory
        String sourceDirectory = "./src/main/java/dk/cb/contractservice/emails/confirmationLetters/";

        // Create the velocity engine
        VelocityEngine ve = new VelocityEngine();

        ve.setProperty( "resource.loader", "file");
        ve.setProperty( "file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
        ve.setProperty( "file.resource.loader.path", sourceDirectory);
        ve.setProperty( "file.resource.loader.cache", true);
        ve.setProperty( "file.resource.loader.modificationCheckInterval", "2");
        ve.init();

        // Get the template
        Template t = ve.getTemplate( "confirmationTemplate.vm" );

        // Create the
        VelocityContext context = new VelocityContext();

        context.put("firstname", contract.getBorrower().getFirstname());
        context.put("lastname", contract.getBorrower().getLastname());
        context.put("bankId", contract.getBankId());
        context.put("amount", contract.getAmount());
        context.put("gender", client.getGender(contract.getBorrower().getFirstname()));

        try {
            // Create the output file
            Writer out = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(
                                    new File( sourceDirectory + "confirmation_" + contract.getId() + ".txt")),
                            "UTF8") );
            t.merge( context, out);

            out.close();
        } catch ( Exception e ){
            e.printStackTrace();
        }
    }
}
