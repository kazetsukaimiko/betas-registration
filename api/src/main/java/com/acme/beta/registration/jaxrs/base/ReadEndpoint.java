package com.acme.beta.registration.jaxrs.base;

import com.acme.beta.registration.model.Model;

import javax.ws.rs.GET;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * JAX-RS Endpoint supporting reads
 * @param <I> Id class of Model.
 * @param <M> Model class.
 */
public interface ReadEndpoint<I, M extends Model<I>> {
    String ID_PARAM = "id";

    /**
     * Finds an entity by its identifier.
     * @param idParam the id to find by
     * @return The model representing the entity.
     * @throws NotFoundException if the entity doesn't exist
     * @throws NotAuthorizedException if you are not authorized to read that entity
     */
    @GET
    @Path("/byId/{" + ID_PARAM + "}")
    M findById(@PathParam(ID_PARAM) I idParam) throws NotFoundException, NotAuthorizedException;
}
