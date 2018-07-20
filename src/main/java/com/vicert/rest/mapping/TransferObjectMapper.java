package com.vicert.rest.mapping;

import com.vicert.domain.Customer;
import com.vicert.domain.Order;
import com.vicert.exceptions.MarketAppException;
import com.vicert.rest.transferobjects.TOCustomer;
import com.vicert.rest.transferobjects.TOOrder;

import java.util.UUID;

/**
 * Created by petrovicu on 20/07/2018.
 */
public class TransferObjectMapper {

    /**
     * @param tOrder
     * @param eOrder
     */
    public static void mapTransferOrderToEntityOrder(TOOrder tOrder, Order eOrder) throws MarketAppException {
        if (tOrder == null) {
            throw new MarketAppException("Transfer object is NULL");
        }
        if (eOrder == null) {
            eOrder = new Order();
        }
        eOrder.setRefId(UUID.randomUUID());
        eOrder.setOrderStatusId(tOrder.getOrderStatusId());

        Customer eCustomer = new Customer();
        mapTransferCustomerToEntityCustomer(tOrder.getCustomer(), eCustomer);
        eOrder.setCustomer(eCustomer);
    }

    /**
     * @param eOrder
     * @param tOrder
     */
    public static void mapEntityOrderToTransferOrder(Order eOrder, TOOrder tOrder) {

    }

    /**
     * @param tCustomer
     * @param eCustomer
     */
    public static void mapTransferCustomerToEntityCustomer(TOCustomer tCustomer, Customer eCustomer) throws MarketAppException {
        if (tCustomer == null) {
            throw new MarketAppException("Transfer object is NULL");
        }
        if (eCustomer == null) {
            eCustomer = new Customer();
        }
        eCustomer.setAddress(tCustomer.getAddress());
        eCustomer.setEmail(tCustomer.getEmail());
        eCustomer.setPassword(tCustomer.getPassword());
        eCustomer.setRefId(UUID.randomUUID());
    }

    /**
     * @param eCustomer
     * @param tCustomer
     */
    public static void mapEntityCustomerToTransferCustomer(Customer eCustomer, TOCustomer tCustomer) {
        if (tCustomer == null) {
            tCustomer = new TOCustomer();
        }
        tCustomer.setAddress(eCustomer.getAddress());
        tCustomer.setEmail(eCustomer.getEmail());
        tCustomer.setPassword(eCustomer.getPassword());
    }
}
