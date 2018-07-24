package com.klaymen.security;

/**
 * Created by petrovicu on 24/07/2018.
 */
public enum UserRights {

    VALID_CUSTOMER("Customer");

    private String value;

    private UserRights(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
