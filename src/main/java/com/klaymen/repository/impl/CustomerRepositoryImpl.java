package com.klaymen.repository.impl;

import com.klaymen.domain.Customer;
import com.klaymen.repository.CustomerRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 * Created by petrovicu on 23/07/2018.
 */
@Repository
public class CustomerRepositoryImpl extends BaseRepositoryImpl implements CustomerRepository {

    @Override
    public Customer authenticateCustomer(String email, String password) {
        if (email == null) {
            return null;
        }
        TypedQuery<Customer> q = em.createQuery(
                "FROM Customer customer WHERE customer.email = :email AND customer.password = :password", Customer.class);
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

    @Override
    public Customer getCustomerByEmail(String email) {
        if (email == null) {
            return null;
        }
        TypedQuery<Customer> q = em.createQuery(
                "FROM Customer customer WHERE customer.email = :email", Customer.class);
        q.setParameter("email", email);
        try {
            return (Customer) q.getSingleResult();
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Customer getCustomerById(int id) {
        TypedQuery<Customer> q = em.createQuery(
                "FROM Customer customer WHERE customer.id = :id", Customer.class);
        q.setParameter("id", id);
        try {
            return (Customer) q.getSingleResult();
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (NoResultException e) {
            return null;
        }
    }
}
