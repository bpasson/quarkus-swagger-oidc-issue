package io.quarkus.rest;

import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/api")
//@SecurityScheme(securitySchemeName = "Example Authentication",
//        description = "Your OIDC token",
//        type = SecuritySchemeType.OPENIDCONNECT,
//        openIdConnectUrl = "https://auth.cloud.bliep.net/auth/realms/uplandobserver/.well-known/openid-configuration")
public class HelloResource {

    @Path("/hello")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String,String> hello() {
        return Map.of("Hello", "World");
    }
}
