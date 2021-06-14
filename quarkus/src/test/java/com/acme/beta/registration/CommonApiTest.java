package com.acme.beta.registration;

import com.acme.beta.registration.jaxrs.BetaRegistrationEndpoint;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.jupiter.api.BeforeEach;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public abstract class CommonApiTest<API> {

    protected abstract Class<API> apiClass();

    /**
     * Turns the JAX-RS interface into a full HTTP client proxy.
     */
    @BeforeEach
    public void makeClientProxy() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://127.0.0.1:8081/");
        ResteasyWebTarget resteasyWebTarget = (ResteasyWebTarget)target;
        api = resteasyWebTarget.proxy(apiClass());
    }

    private API api;

    public API getApi() {
        return api;
    }
}
