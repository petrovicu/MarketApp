package com.klaymen.rest.transferobjects;

import java.util.List;

/**
 * Created by petrovicu on 19/07/2018.
 */
public class CreateOrderRequest {

    private String orderStatusId;
    private List<TOOrderLineRequest> orderLines;

    /**
     * For serialization
     */
    public CreateOrderRequest() {
    }

    public CreateOrderRequest(String orderStatusId, List<TOOrderLineRequest> orderLines) {
        this.orderStatusId = orderStatusId;
        this.orderLines = orderLines;
    }

    //******** GETTERS AND SETTERS ***********
    public String getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(String orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public List<TOOrderLineRequest> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<TOOrderLineRequest> orderLines) {
        this.orderLines = orderLines;
    }
}
