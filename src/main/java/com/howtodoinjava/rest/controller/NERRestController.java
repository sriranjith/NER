package com.howtodoinjava.rest.controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.howtodoinjava.rest.ner.NERExtraction;

@Path("/ner")
@Produces(MediaType.APPLICATION_JSON)
public class NERRestController {

	@POST
	@Path("/date")
	public Response getDateType(@QueryParam("text") String text) {
		return Response.ok(NERExtraction.getEntityType(text)).build();
	}

}
