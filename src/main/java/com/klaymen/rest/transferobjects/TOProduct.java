package com.klaymen.rest.transferobjects;

/**
 * Created by petrovicu on 19/07/2018.
 */
public class TOProduct {

    private TOPrice price;
    private String name;

    /**
     * For serialization
     */
    public TOProduct() {
    }

    public TOProduct(TOPrice price, String name) {
        this.price = price;
        this.name = name;
    }

    //******** GETTERS AND SETTERS ***********
    public TOPrice getPrice() {
        return price;
    }

    public void setPrice(TOPrice price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
