package com.teducci.controllers;


import com.teducci.commons.rest_client.Mailgun2Service;
import com.teducci.dtos.MessageDto;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.net.URI;

@Path("/test2")
public class Mailgun2Controller {

    private final Mailgun2Service mailgunService2;

    public Mailgun2Controller(@ConfigProperty(name = "quarkus.rest-client.mailgun-api.url") String hostMailgun) {
        mailgunService2 = RestClientBuilder.newBuilder()
                .baseUri(URI.create(hostMailgun))
                .build(Mailgun2Service.class);
    }

    @GET
    public MessageDto sendMail2() {
        return mailgunService2.testMail();
    }
}
