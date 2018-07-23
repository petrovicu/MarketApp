package com.klaymen.rest.transferobjects;

/**
 * Created by petrovicu on 19/07/2018.
 */
public class TOOrderLine {

    private TOProduct product;
    private int quantity;

    /**
     * For serialization
     */
    public TOOrderLine() {
    }

    public TOOrderLine(TOProduct product, int quantity) {
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
