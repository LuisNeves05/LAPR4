package eapli.base.clientusermanagement.jpa;

import eapli.base.Application;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


/**
 * An utility abstract class for implementing JPA repositories. based on
 * JpaRepository by Paulo Gandra de Sousa
 *
 * @param <T> the entity type that we want to build a repository for
 * @param <ID> the key type of the entity
 */
public abstract class JpaRepositorio<T, ID extends Serializable> {

    @PersistenceUnit
    private static EntityManagerFactory emFactory;
    private final Class<T> entityClass;
    private EntityManager _entityManager;

    protected EntityManagerFactory entityManagerFactory() {
        if (emFactory == null) {
            emFactory = Persistence
                    .createEntityManagerFactory(persistenceUnitName());
        }
        return emFactory;
    }

    @SuppressWarnings("unchecked")
    public JpaRepositorio() {
        ParameterizedType genericSuperclass
                = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass
                = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    protected EntityManager entityManager() {
        if (_entityManager == null || !_entityManager.isOpen()) {
            _entityManager = entityManagerFactory().createEntityManager();
        }
        return _entityManager;
    }

    /**
     * inserts an entity and commits
     *
     * @param entity
     * @return the persisted entity
     */
    public T add(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException();
        }
        EntityManager em = entityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(entity);
        tx.commit();
        em.close();

        return entity;
    }

    /**
     * reads an entity given its ID
     *
     * @param id
     * @return
     */
    public T findById(ID id) {
        return this.entityManager().find(entityClass, id);
    }

    /**
     * Returns the List of all entities in the persistence store
     *
     * @return
     */
    //@SuppressWarnings("unchecked")
    public List<T> findAll() {
        Query query = entityManager().createQuery(
                "SELECT e FROM " + entityClass.getSimpleName() + " e");
        List<T> list = query.getResultList();
        return list;
    }

    /**
     * derived classes should implement this method to return the name of the
     * persistence unit
     *
     * @return the name of the persistence unit
     */
    protected abstract String persistenceUnitName();
}