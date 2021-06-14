package com.acme.beta.registration.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.metamodel.SingularAttribute;

@ApplicationScoped
public class DeveloperPersistence extends JPAPersistence<Long, PersistedDeveloper> {
    @Override
    Class<PersistedDeveloper> getEntityClass() {
        return PersistedDeveloper.class;
    }

    @Override
    SingularAttribute<PersistedDeveloper, Long> getIdAttribute() {
        return PersistedDeveloper_.id;
    }
}
