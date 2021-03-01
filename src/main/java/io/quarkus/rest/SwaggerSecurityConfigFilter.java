package io.quarkus.rest;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.openapi.OASFactory;
import org.eclipse.microprofile.openapi.OASFilter;
import org.eclipse.microprofile.openapi.models.OpenAPI;
import org.eclipse.microprofile.openapi.models.security.SecurityScheme;

import java.util.HashMap;
import java.util.Map;

public class SwaggerSecurityConfigFilter implements OASFilter {

    private final Config config = ConfigProvider.getConfig();

    @Override
    public void filterOpenAPI(OpenAPI openAPI) {

        // Get the authorizationUrl and refreshUrl from Config
        String authServer = config.getValue("quarkus.oidc.swagger.auth-server-url", String.class);
        if( !authServer.endsWith("/")) {
            authServer += "/";
        }


        // Make sure components are created
        if (openAPI.getComponents() == null) {
            openAPI.setComponents(OASFactory.createComponents());
        }

        // Add company security scheme
        Map<String, SecurityScheme> securitySchemes = new HashMap<>();
        SecurityScheme securityScheme = OASFactory.createSecurityScheme();
        securityScheme.setType(SecurityScheme.Type.OPENIDCONNECT);
        securityScheme.setOpenIdConnectUrl(authServer + ".well-known/openid-configuration");
        securitySchemes.put("authentication", securityScheme);
        openAPI.getComponents().setSecuritySchemes(securitySchemes);
    }

}
