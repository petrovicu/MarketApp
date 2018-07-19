package com.vicert.rest.transferobjects;

/**
 * Created by petrovicu on 19/07/2018.
 */
public class TOPrice {

    private Double amount;
    private ECurrency currency;

    /**
     * For serialization
     */
    public TOPrice() {
    }

    public TOPrice(Double amount, ECurrency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    //******** GETTERS AND SETTERS ***********
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public ECurrency getCurrency() {
        return currency;
    }

    public void setCurrency(ECurrency currency) {
        this.currency = currency;
    }
}
