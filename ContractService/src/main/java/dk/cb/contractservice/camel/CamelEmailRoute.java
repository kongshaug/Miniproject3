package dk.cb.contractservice.camel;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Producer;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Component;

@Component
public class CamelEmailRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
 /*       CamelContext context = new DefaultCamelContext();

        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() {

                PropertiesComponent pc = getContext().getComponent("properties", PropertiesComponent.class);
                pc.setLocation("classpath:mail.properties");

                from("direct:start")
                        .to("smtp://{{smtp.host}}?username={{smtp.username}}&password={{smtp.password}}&from={{smtp.from.email}}&contentType={{contentType}}")
                        .log("Email sent with content ${in.body}");

            }
        });

        // start the route and let it do its work

        context.start();

        Endpoint endpoint = context.getEndpoint("direct:start");

        // create the exchange with the mail message that is multipart with a file and a Hello World text/plain message.
        Exchange exchange = endpoint.createExchange();
        Message in = exchange.getIn();
        in.setHeader("subject", "Camel logo updated !");
        in.setHeader("to", "guest@camelmail.com");
        in.setHeader("from", "usertwo@camelmail.com");
        in.setBody("Logo is in attachment");
        in.addAttachment("logo.jpeg", new DataHandler(new FileDataSource("src/main/resources/camellogo.jpg")));


        // create a producer that can produce the exchange (= send the mail)
        Producer producer = endpoint.createProducer();
        // start the producer
        producer.start();
        // and let it go (processes the exchange by sending the email)
        producer.process(exchange);

        context.stop();*/
    }
}
