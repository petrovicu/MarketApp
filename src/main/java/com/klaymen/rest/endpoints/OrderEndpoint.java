package com.klaymen.rest.endpoints;

import com.klaymen.domain.Customer;
import com.klaymen.domain.Order;
import com.klaymen.domain.OrderLine;
import com.klaymen.exceptions.MarketAppException;
import com.klaymen.rest.mapping.TransferObjectMapper;
import com.klaymen.rest.transferobjects.RestResponseObject;
import com.klaymen.rest.transferobjects.TOOrder;
import com.klaymen.rest.transferobjects.TOOrderLine;
import com.klaymen.service.CustomerService;
import com.klaymen.service.OrderService;
import com.klaymen.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by petrovicu on 19/07/2018.
 */
@RestController
@RequestMapping("/secured/order")
public class OrderEndpoint {

    @Autowired
    private OrderService orderService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/createOrder", method = RequestMethod.POST, headers = "Accept=application/json;charset=utf-8")
    public ResponseEntity<RestResponseObject> createOrder(@RequestBody TOOrder tOrder) {
        try {
            Order newOrder = new Order();

            // Map transfer Order -> entity Order
            TransferObjectMapper.mapTransferOrderToEntityOrder(tOrder, newOrder);

            if (tOrder.getOrderLines() != null && !tOrder.getOrderLines().isEmpty()) {
                List<OrderLine> orderLines = new ArrayList<>();
                for (TOOrderLine tLine : tOrder.getOrderLines()) {
                    OrderLine newLine = new OrderLine();
                    newLine.setOrder(newOrder);
                    newLine.setQuantity(tLine.getQuantity());
                    newLine.setProduct(productService.getProductById(tLine.getProductId()));

                    orderLines.add(newLine);
                }
                newOrder.setOrderLines(orderLines);
            }

            // Map customer part - take it from session
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String customerEmail = (String) authentication.getPrincipal();
            Customer dbCustomer = customerService.getCustomerByEmail(customerEmail);
            newOrder.setCustomer(dbCustomer);

            return new ResponseEntity(new RestResponseObject(true, "Order created with ID: " +
                    orderService.createOrder(newOrder).toString()), HttpStatus.OK);
        } catch (MarketAppException e) {
            return new ResponseEntity(new RestResponseObject(false, "Error mapping transfer objects"),
                    HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(value = "/getOrderById", method = RequestMethod.GET, headers = "Accept=application/json;charset=utf-8")
    public ResponseEntity<RestResponseObject> getOrderById(@RequestParam int orderId) {
        //EAGER by default - it will fetch referenced Customer
        Order dbOrder = orderService.getOrderWithProductById(orderId);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String customerEmail = (String) authentication.getPrincipal();
        Customer dbCustomer = customerService.getCustomerByEmail(customerEmail);
        if (dbCustomer != null && dbCustomer.getId() != dbOrder.getCustomer().getId()) {
            return new ResponseEntity(new RestResponseObject(false, "Non-proper customer id. Dear customer, you cannot fetch this order"),
                    HttpStatus.NOT_ACCEPTABLE);
        }
        TOOrder tOrder = new TOOrder();
        try {
            TransferObjectMapper.mapEntityOrderToTransferOrder(dbOrder, tOrder);
        } catch (MarketAppException e1) {
            return new ResponseEntity(new RestResponseObject(false, "Error mapping transfer objects"),
                    HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(tOrder, HttpStatus.OK);
    }
}
