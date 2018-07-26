package com.klaymen.rest.transferobjects;

/**
 * Created by petrovicu on 26/07/2018.
 */
public class TOOrderLineRequest {

    private int productId;
    private int quantity;

    /**
     * For serialization
     */
    public TOOrderLineRequest() {
    }

    public TOOrderLineRequest(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    //******** GETTERS AND SETTERS ***********
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
