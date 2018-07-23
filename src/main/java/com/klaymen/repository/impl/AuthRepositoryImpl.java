package com.klaymen.repository.impl;

import com.klaymen.domain.Customer;
import com.klaymen.repository.AuthRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 * Created by petrovicu on 23/07/2018.
 */
@Repository
public class AuthRepositoryImpl extends BaseRepositoryImpl implements AuthRepository {

    @Override
    public Customer authenticateUser(String email, String password) {
        if (email == null)
            return null;
        TypedQuery<Customer> q = em.createQuery(
                "from Customer customer where customer.email = :email and customer.password = :password", Customer.class);
        q.setParameter("email", email);
        q.setParameter("password", password);
        try {
            return (Customer) q.getSingleResult();
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (NoResultException e) {
            return null;
        }
    }
}
