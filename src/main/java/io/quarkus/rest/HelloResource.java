package io.quarkus.rest;

import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/api")
@SecurityRequirement(name = "authentication", scopes = {})
public class HelloResource {

    @Path("/hello")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"read","edit","admin"})
    public Map<String, String> hello() {
        return Map.of("Hello", "World");
    }
}
