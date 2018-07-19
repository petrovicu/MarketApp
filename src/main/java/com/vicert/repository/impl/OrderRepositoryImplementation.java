package com.vicert.repository.impl;

import com.vicert.domain.Order;
import com.vicert.repository.OrderRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 * Created by petrovicu on 19/07/2018.
 */
public class OrderRepositoryImplementation extends BaseRepositoryImpl implements OrderRepository {

    @Override
    public void createOrder(int id) {
        persist(new Order());
    }

    @Override
    public Order getOrderById(int id) {
        TypedQuery<Order> q = em.createQuery(
                "from Order order where order.id = :id", Order.class);
        q.setParameter("id", id);
        try {
            return (Order) q.getSingleResult();
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (NoResultException e) {
            return null;
        }
    }
}
