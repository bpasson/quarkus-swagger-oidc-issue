package io.quarkus.rest;

import io.quarkus.oidc.TenantResolver;
import io.vertx.ext.web.RoutingContext;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomTenantResolver implements TenantResolver {

    @Override
    public String resolve(RoutingContext context) {
        if( context.normalisedPath().startsWith("/api/")) {
            return null;
        }
        return "swagger";
    }
}
