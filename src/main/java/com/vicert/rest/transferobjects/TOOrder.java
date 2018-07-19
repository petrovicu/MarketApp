package com.vicert.rest.transferobjects;

import java.util.List;

/**
 * Created by petrovicu on 19/07/2018.
 */
public class TOOrder {

    private TOCustomer customer;
    private String orderStatusId;
    private List<TOOrderLine> orderLines;

    /**
     * For serialization
     */
    public TOOrder() {
    }

    public TOOrder(TOCustomer customer, String orderStatusId, List<TOOrderLine> orderLines) {
        this.customer = customer;
        this.orderStatusId = orderStatusId;
        this.orderLines = orderLines;
    }

    //******** GETTERS AND SETTERS ***********
    public TOCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(TOCustomer customer) {
        this.customer = customer;
    }

    public String getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(String orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public List<TOOrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<TOOrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
