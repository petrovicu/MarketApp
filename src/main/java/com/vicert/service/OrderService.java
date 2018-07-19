package com.vicert.service;

import com.vicert.domain.Order;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by petrovicu on 19/07/2018.
 */
@Service
@Transactional
public interface OrderService {

    /**
     * Creates an order with requested ID.
     *
     * @param id
     * @return
     */
    public Order createOrder(int id);

    /**
     * Returns an Order with corresponding Product data
     *
     * @param id
     */
    public void getOrderWithProductById(int id);
}
