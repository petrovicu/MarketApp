package com.vicert.service.impl;

import com.vicert.domain.Order;
import com.vicert.repository.OrderRepository;
import com.vicert.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by petrovicu on 19/07/2018.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Integer createOrder(Order order) {
        Integer orderId = orderRepository.createOrder(order);
        System.out.printf("Order with order ID:%d successfully created.", orderId);
        return orderId;
    }

    @Override
    public Order getOrderWithProductById(int id) {
        return orderRepository.getOrderById(id);
    }
}
