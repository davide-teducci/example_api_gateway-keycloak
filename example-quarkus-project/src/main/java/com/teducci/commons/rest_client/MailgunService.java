package com.teducci.commons.rest_client;

import com.teducci.dtos.MessageDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
@RegisterRestClient(configKey="mailgun-api")
public interface MailgunService {

    @Path("/transaction-test")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    MessageDto testService();
}
