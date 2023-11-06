package com.teducci.commons.rest_client;

import com.teducci.dtos.MessageDto;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/test")
public interface Mailgun2Service {

    @GET
    @Path("/transaction-test")
    MessageDto testMail();
}
