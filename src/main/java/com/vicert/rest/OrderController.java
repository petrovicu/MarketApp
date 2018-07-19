package com.vicert.rest;

import com.vicert.rest.transferobjects.RestResponseObject;
import com.vicert.rest.transferobjects.TOOrder;
import com.vicert.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by petrovicu on 19/07/2018.
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

//    @PostMapping("/createOrder")
//    @ResponseBody
    @RequestMapping(value="/createOrder", method = RequestMethod.POST, headers="Accept=application/json;charset=utf-8")
    public ResponseEntity<RestResponseObject> createOrderById(@RequestBody TOOrder order) {
        return new ResponseEntity(order, HttpStatus.OK);
    }

}
