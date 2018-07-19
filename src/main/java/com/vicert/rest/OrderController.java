package com.vicert.rest;

import com.vicert.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by petrovicu on 19/07/2018.
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/createOrder")
    @ResponseBody
    public ResponseEntity createOrderById(@RequestParam(name = "orderId", required = true) String orderId) {
        return new ResponseEntity(orderService.createOrder(Integer.valueOf(orderId)), HttpStatus.OK);
    }

}
