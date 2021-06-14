package com.acme.beta.registration.servivce;

import com.acme.beta.registration.jaxrs.DevelopmentEndpoint;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Path;

@Path("/beta/options")
@ApplicationScoped
public class DevelopmentOptionsService implements DevelopmentEndpoint {
}
