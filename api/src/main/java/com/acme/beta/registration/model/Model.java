package com.acme.beta.registration.model;

/**
 * Model class with an known identifier type
 */
public interface Model<I> {
    void setId(I id);
    I getId();
}
