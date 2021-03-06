package com.klaymen.rest.mapping;

import com.klaymen.domain.Customer;
import com.klaymen.domain.Order;
import com.klaymen.domain.OrderLine;
import com.klaymen.exceptions.MarketAppException;
import com.klaymen.rest.transferobjects.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by petrovicu on 20/07/2018.
 */
public class TransferObjectMapper {

    /**
     * @param createOrderRequest
     * @param eOrder
     */
    public static void mapTransferOrderToEntityOrder(CreateOrderRequest createOrderRequest, Order eOrder) throws MarketAppException {
        if (createOrderRequest == null) {
            throw new MarketAppException("Order transfer object is NULL");
        }
        if (eOrder == null) {
            eOrder = new Order();
        }
        eOrder.setRefId(UUID.randomUUID());
        eOrder.setOrderStatusId(createOrderRequest.getOrderStatusId());

        //Map OrderLines
//        if (createOrderRequest.getOrderLines() != null && !createOrderRequest.getOrderLines().isEmpty()) {
//            List<OrderLine> orderLines = new ArrayList<OrderLine>();
//            for (TOOrderLine tOrderLine : createOrderRequest.getOrderLines()) {
//                OrderLine iOrderLine = new OrderLine();
//                iOrderLine.setQuantity(tOrderLine.getQuantity());
//                if (tOrderLine.getProduct() != null) {
//                    Product iProduct = new Product();
//                    iProduct.setName(tOrderLine.getProduct().getName());
//                    iProduct.setPrice(tOrderLine.getProduct().getPrice() != null ? Money.of(tOrderLine.getProduct().getPrice().getAmount(),
//                            tOrderLine.getProduct().getPrice().getCurrency().toString()) :
//                            null);
//                    iProduct.setRefId(UUID.randomUUID());
//                    iOrderLine.setProduct(iProduct);
//                }
//                iOrderLine.setOrder(eOrder);
//                orderLines.add(iOrderLine);
//            }
//            eOrder.setOrderLines(orderLines);
//        }
    }

    /**
     * @param eOrder
     * @param getOrderResponse
     */
    public static void mapEntityOrderToTransferOrder(Order eOrder, GetOrderResponse getOrderResponse) throws MarketAppException {
        if (eOrder == null) {
            throw new MarketAppException("DB ORDER entity is NULL");
        }
        if (getOrderResponse == null) {
            getOrderResponse = new GetOrderResponse();
        }
        getOrderResponse.setOrderStatusId(eOrder.getOrderStatusId());

        //Map OrderLines
        if (eOrder.getOrderLines() != null && !eOrder.getOrderLines().isEmpty()) {
            List<TOOrderLineResponse> tOrderLines = new ArrayList<TOOrderLineResponse>();
            for (OrderLine eOrderLine : eOrder.getOrderLines()) {
                TOOrderLineResponse iOrderLine = new TOOrderLineResponse();
                iOrderLine.setQuantity(eOrderLine.getQuantity());
                if (eOrderLine.getProduct() != null) {
                    iOrderLine.setProduct(new TOProduct(new TOPrice(eOrderLine.getProduct().getPrice().getNumber().doubleValue(),
                            ECurrency.valueOf(eOrderLine.getProduct().getPrice().getCurrency().getCurrencyCode())), eOrderLine.getProduct().getName()));
                }
                tOrderLines.add(iOrderLine);
            }
            getOrderResponse.setOrderLines(tOrderLines);

//        if (eOrder.getOrderLines() != null && !eOrder.getOrderLines().isEmpty()) {
//            List<TOOrderLine> tOrderLines = new ArrayList<TOOrderLine>();
//            for (OrderLine eOrderLine : eOrder.getOrderLines()) {
//                TOOrderLine iOrderLine = new TOOrderLine();
//                iOrderLine.setQuantity(eOrderLine.getQuantity());
//                if (eOrderLine.getProduct() != null) {
//                    TOProduct iProduct = new TOProduct();
//                    iProduct.setName(eOrderLine.getProduct().getName());
//                    iProduct.setPrice(eOrderLine.getProduct().getPrice() != null ? new TOPrice(eOrderLine.getProduct().getPrice().getNumber().doubleValue(),
//                            ECurrency.valueOf(eOrderLine.getProduct().getPrice().getCurrency().getCurrencyCode())) : null);
//                    iOrderLine.setProduct(iProduct);
//                }
//                tOrderLines.add(iOrderLine);
//            }
//            getOrderResponse.setOrderLines(tOrderLines);
//        }
        }
    }

    /**
     * @param tCustomer
     * @param eCustomer
     */

    public static void mapTransferCustomerToEntityCustomer(TOCustomer tCustomer, Customer eCustomer) throws MarketAppException {
        if (tCustomer == null) {
            throw new MarketAppException("Customer transfer object is NULL");
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
    public static void mapEntityCustomerToTransferCustomer(Customer eCustomer, TOCustomer tCustomer) throws MarketAppException {
        if (eCustomer == null) {
            throw new MarketAppException("DB CUSTOMER object object is NULL");
        }
        if (tCustomer == null) {
            tCustomer = new TOCustomer();
        }
        tCustomer.setAddress(eCustomer.getAddress());
        tCustomer.setEmail(eCustomer.getEmail());
        tCustomer.setPassword(eCustomer.getPassword());
    }


}
