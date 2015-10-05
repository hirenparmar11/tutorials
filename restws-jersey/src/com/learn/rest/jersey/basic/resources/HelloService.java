package com.learn.rest.jersey.basic.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("say-hello")
public class HelloService {

	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHello(@PathParam("name") String name) {
		return "{\"message\":\"Hello! Jersey - from " + name +"\"}";
	}
}
