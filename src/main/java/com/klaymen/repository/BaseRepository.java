package com.klaymen.repository;

import com.klaymen.domain.BaseEntity;
import org.springframework.stereotype.Repository;

/**
 * @param <E>
 */
@Repository
public interface BaseRepository<E extends BaseEntity> {

    public E save(E domainObject);

    public E persist(E domainObject);

    public E merge(E domainObject);

    public E findById(Class<? extends E> clazz, Long id);

    public void flush();

    public void delete(E domainObject);
}
