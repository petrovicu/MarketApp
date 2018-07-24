package com.klaymen.repository.impl;

import com.klaymen.domain.Product;
import com.klaymen.repository.ProductRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 * Created by petrovicu on 23/07/2018.
 */
@Repository
public class ProductRepositoryImpl extends BaseRepositoryImpl implements ProductRepository {


    @Override
    public Product getProductById(int id) {
        TypedQuery<Product> q = em.createQuery(
                "FROM Product p WHERE p.id = :id", Product.class);
        q.setParameter("id", id);
        try {
            return (Product) q.getSingleResult();
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (NoResultException e) {
            return null;
        }
    }
}
