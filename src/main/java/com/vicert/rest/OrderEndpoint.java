package com.vicert.rest;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.vicert.domain.Order;
import com.vicert.exceptions.MarketAppException;
import com.vicert.rest.mapping.TransferObjectMapper;
import com.vicert.rest.transferobjects.RestResponseObject;
import com.vicert.rest.transferobjects.TOOrder;
import com.vicert.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by petrovicu on 19/07/2018.
 */
@Controller
public class OrderEndpoint {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/createOrder", method = RequestMethod.POST, headers = "Accept=application/json;charset=utf-8")
    public ResponseEntity<RestResponseObject> createOrder(@RequestBody TOOrder tOrder) {
        try {
            Order newOrder = new Order();
            TransferObjectMapper.mapTransferOrderToEntityOrder(tOrder, newOrder);
            return new ResponseEntity(orderService.createOrder(newOrder), HttpStatus.OK);
        } catch (MarketAppException e){
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(value = "/getOrderById", method = RequestMethod.GET, headers = "Accept=application/json;charset=utf-8")
    public ResponseEntity<RestResponseObject> getOrderById(@RequestParam int id) {
        Order dbOrder = orderService.getOrderWithProductById(id);
        try {
            TOOrder tOrder = new TOOrder();
            TransferObjectMapper.mapEntityOrderToTransferOrder(dbOrder, tOrder);
            return new ResponseEntity(tOrder, HttpStatus.OK);
        } catch (MarketAppException e) {
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
