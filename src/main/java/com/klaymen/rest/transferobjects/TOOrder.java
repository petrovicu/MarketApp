package com.klaymen.rest.transferobjects;

import java.util.List;

/**
 * Created by petrovicu on 19/07/2018.
 */
public class TOOrder {

//    private int customerId;
    private String orderStatusId;
    private List<TOOrderLine> orderLines;

    /**
     * For serialization
     */
    public TOOrder() {
    }

    public TOOrder(int customerId, String orderStatusId, List<TOOrderLine> orderLines) {
//        this.customerId = customerId;
        this.orderStatusId = orderStatusId;
        this.orderLines = orderLines;
    }

    //******** GETTERS AND SETTERS ***********
//    public int getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(int customerId) {
//        this.customerId = customerId;
//    }

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
