package com.acme.beta.registration.jaxrs;

import com.acme.beta.registration.jaxrs.base.CRUDEndpoint;
import com.acme.beta.registration.model.DevId;
import com.acme.beta.registration.model.Developer;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/beta/developers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface BetaRegistrationEndpoint extends CRUDEndpoint<DevId, Developer> {
    String DELETE_RESPONSE = "OK";
}
