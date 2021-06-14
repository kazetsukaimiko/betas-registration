package com.acme.beta.registration.jaxrs.base;

import com.acme.beta.registration.model.Model;

import javax.ws.rs.DELETE;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * JAX-RS Endpoint supporting entity deletion
 * @param <I> Id class of Model.
 * @param <M> Model class.
 */
public interface DeleteEndpoint<I, M extends Model<I>> {
    String ID_PARAM = "id";

    /**
     * Deletes an entity by identifier.
     * @param idParam the identifier of the entity
     * @return A string reprentation of the response code.
     * @throws NotFoundException if the entity was not found
     * @throws NotAuthorizedException if you do not have authorization to delete this entity
     */
    @DELETE
    @Path("/byId/{" + ID_PARAM + "}")
    String deleteById(@PathParam(ID_PARAM) I idParam) throws NotFoundException, NotAuthorizedException;
}
