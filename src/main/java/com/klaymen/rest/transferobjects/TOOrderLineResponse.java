package com.klaymen.rest.transferobjects;

/**
 * Created by petrovicu on 26/07/2018.
 */
public class TOOrderLineResponse {

    private TOProduct product;
    private int quantity;

    /**
     * For serialization
     */
    public TOOrderLineResponse() {
    }

    public TOOrderLineResponse(TOProduct product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    //******** GETTERS AND SETTERS ***********
    public TOProduct getProduct() {
        return product;
    }

    public void setProduct(TOProduct product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
