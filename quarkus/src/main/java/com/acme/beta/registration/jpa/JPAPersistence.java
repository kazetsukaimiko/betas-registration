package com.acme.beta.registration.jpa;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;
import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Generic JPA Persistence superclass.
 * @param <I> type of the ID field
 * @param <M> type of the Entity
 */
public abstract class JPAPersistence<I, M> {
    @Inject
    EntityManager entityManager;

    /**
     * Entity class- used to create queries
     */
    abstract Class<M> getEntityClass();

    /**
     * Attribute of the id field
     */
    abstract SingularAttribute<M, I> getIdAttribute();

    @Transactional
    public M save(M model) {
        entityManager.persist(model);
        return model;
    }

    public Optional<M> get(I id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<M> cq = cb.createQuery(getEntityClass());
        Root<M> root = cq.from(getEntityClass());
        cq.select(root)
                .where(cb.equal(root.get(getIdAttribute()), id));
        return Optional.ofNullable(entityManager.createQuery(cq).getSingleResult());
    }

    @Transactional
    public int delete(I id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaDelete<M> cq = cb.createCriteriaDelete(getEntityClass());
        Root<M> root = cq.from(getEntityClass());
        return entityManager.createQuery(cq.where(cb.equal(root.get(getIdAttribute()), id)))
                .executeUpdate();
    }


}
