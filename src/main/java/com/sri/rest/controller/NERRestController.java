package com.sri.rest.controller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sri.rest.ner.NERExtraction;

@Path("/ner")
@Produces(MediaType.APPLICATION_JSON)
public class NERRestController {

    @GET
    @Path("/date")
    public Response getDateType(@QueryParam("text") String text) {
        return Response.ok(NERExtraction.getEntityType(text)).build();
    }

}
