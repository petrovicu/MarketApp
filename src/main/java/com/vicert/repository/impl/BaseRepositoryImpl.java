package com.vicert.repository.impl;

import com.vicert.domain.BaseEntity;
import com.vicert.repository.BaseRepository;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

/**
 * Base repository methods implementation (persist, merge, delete...)
 *
 * @author petrovicu
 */
@Repository
public class BaseRepositoryImpl implements BaseRepository<BaseEntity> {

    private static final Logger LOGGER = LogManager.getLogger(BaseRepositoryImpl.class);

    @PersistenceContext
    public EntityManager em;

    Class<BaseEntity> type;

    /**
     * Method for saving domain object into database
     * If ID exists, object is persisted, otherwise merged
     *
     * @param domainObject
     * @return
     */
    public BaseEntity save(BaseEntity domainObject) {
        if (domainObject.getId() == null) {
            return persist(domainObject);
        } else {
            return merge(domainObject);
        }
    }

    @Override
    public BaseEntity persist(BaseEntity domainObject) {
        domainObject.setCreated(new Date());
        domainObject.setUpdated(domainObject.getCreated());
        em.persist(domainObject);
        LOGGER.log(Level.DEBUG, "Entity saved with id={" + domainObject.getId() + "}");
        return domainObject;
    }


    @Override
    public BaseEntity merge(BaseEntity domainObject) {
        domainObject.setUpdated(new Date());
        BaseEntity entity = em.merge(domainObject);
        LOGGER.log(Level.DEBUG, "Entity merged with id={" + entity.getId() + "}");
        return entity;
    }

    @Override
    public BaseEntity findById(Class<? extends BaseEntity> clazz, Long id) {
        return em.find(clazz, id);
    }

    @Override
    public void flush() {
        em.flush();
    }

    @Override
    public void delete(BaseEntity domainObject) {
        em.remove(em.merge(domainObject));
        LOGGER.log(Level.DEBUG, "Entity deleted with id={" + domainObject.getId() + "}");
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
