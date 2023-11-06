package com.teducci.controllers;

import com.teducci.commons.rest_client.MailgunService;
import com.teducci.dtos.MessageDto;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/test")
public class MailgunController {

    @Inject
    @RestClient
    MailgunService externalCall;

    @GET
    public Response findAll() {
        MessageDto r = externalCall.testService();
        return Response.ok(r).build();
    }

}
