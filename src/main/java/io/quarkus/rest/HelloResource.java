package io.quarkus.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/api")
public class HelloResource {

    @Path("/hello")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String,String> hello() {
        return Map.of("Hello", "World");
    }
}
