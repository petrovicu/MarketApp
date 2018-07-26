package com.klaymen.rest.transferobjects;

import java.util.List;

/**
 * Created by petrovicu on 19/07/2018.
 */
public class GetOrderResponse {

    private String orderStatusId;
    private List<TOOrderLineResponse> orderLines;

    /**
     * For serialization
     */
    public GetOrderResponse() {
    }

    public GetOrderResponse(String orderStatusId, List<TOOrderLineResponse> orderLines) {
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

    public List<TOOrderLineResponse> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<TOOrderLineResponse> orderLines) {
        this.orderLines = orderLines;
    }
}
