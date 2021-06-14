package com.acme.beta.registration.jaxrs.base;

import com.acme.beta.registration.model.Model;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * JAX-RS Endpoint supporting entity updates
 * @param <I> Id class of Model.
 * @param <M> Model class.
 */
public interface UpdateEndpoint<I, M extends Model<I>> {
    String ID_PARAM = "id";

    /**
     * Updates an existing entity by Model.
     * @param idParam Path paramerter of the entity to update
     * @param update The model representing the new entity state.
     * @return The model state post persistence.
     * @throws NotFoundException if the entity doesn't exist
     * @throws BadRequestException if the entity s invalid
     * @throws NotAuthorizedException if you aren't authorized to update this entity
     */
    @PUT
    @Path("/byId/{" + ID_PARAM + "}")
    M updateId(@PathParam(ID_PARAM) I idParam, M update) throws NotFoundException, BadRequestException, NotAuthorizedException;
}
