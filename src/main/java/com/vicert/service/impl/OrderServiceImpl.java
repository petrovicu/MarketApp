package com.vicert.service.impl;

import com.vicert.domain.Order;
import com.vicert.service.OrderService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by petrovicu on 19/07/2018.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    public Order createOrder(int id) {
        System.out.printf("Order with id:%d successfully created.", id);
        return new Order();
    }

    @Override
    public void getOrderWithProductById(int id) {
        return;
    }
}
