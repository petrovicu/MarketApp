package com.klaymen.rest.transferobjects;

/**
 * Created by petrovicu on 19/07/2018.
 */
public class TOOrderLine {

    private int productId;
    private int quantity;

    /**
     * For serialization
     */
    public TOOrderLine() {
    }

    public TOOrderLine(int productId, int quantity) {
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
