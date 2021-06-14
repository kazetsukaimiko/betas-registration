package com.acme.beta.registration.jaxrs;


import com.acme.beta.registration.model.DevelopmentOptions;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Endpoint to get known enum values
 */
@Path("/beta/options")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface DevelopmentEndpoint {
    @GET
    default DevelopmentOptions getOptions() {
        return new DevelopmentOptions();
    }
}
