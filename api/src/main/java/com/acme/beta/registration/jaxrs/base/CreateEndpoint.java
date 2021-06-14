package com.acme.beta.registration.jaxrs.base;

import com.acme.beta.registration.model.Model;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.POST;

/**
 * JAX-RS Endpoint supporting entity creation
 * @param <I> Id class of Model.
 * @param <M> Model class.
 */
public interface CreateEndpoint<I, M extends Model<I>> {
    /**
     * Creates an entity.
     * @param input The model to be created.
     * @return The model state post persistence.
     * @throws BadRequestException if the payload doesn't conform to Model
     */
    @POST
    M create(M input) throws BadRequestException;
}
