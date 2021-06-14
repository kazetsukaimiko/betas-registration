package com.acme.beta.registration.jaxrs.base;

import com.acme.beta.registration.model.Model;

/**
 * JAX-RS Endpoint supporting full, basic entity CRUD
 * @param <I> Id class of Model.
 * @param <M> Model class.
 */
public interface CRUDEndpoint<I, M extends Model<I>> extends CreateEndpoint<I, M>, ReadEndpoint<I, M>, UpdateEndpoint<I, M>, DeleteEndpoint<I, M> {
}
