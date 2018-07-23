package com.klaymen.rest.endpoints;

import com.klaymen.domain.Order;
import com.klaymen.exceptions.MarketAppException;
import com.klaymen.rest.mapping.TransferObjectMapper;
import com.klaymen.rest.transferobjects.RestResponseObject;
import com.klaymen.rest.transferobjects.TOOrder;
import com.klaymen.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by petrovicu on 19/07/2018.
 */
@RestController
@RequestMapping("/secured/order")
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
