package com.klaymen.service;

import com.klaymen.domain.Order;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by petrovicu on 19/07/2018.
 */
@Service
@Transactional
public interface OrderService {

    /**
     * Creates an order.
     *
     * @param order
     * @return order id
     */
    public Integer createOrder(Order order);

    /**
     * Returns an Order with corresponding Product data
     *
     * @param id
     */
    public Order getOrderWithProductById(int id);
}
