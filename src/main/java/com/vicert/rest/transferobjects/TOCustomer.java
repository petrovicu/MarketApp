package com.vicert.rest.transferobjects;

/**
 * Created by petrovicu on 19/07/2018.
 */
public class TOCustomer {

    private String email;
    private String address;
    private String password;

    /**
     * For serialization
     */
    public TOCustomer() {
    }

    public TOCustomer(String email, String address, String password) {
        this.email = email;
        this.address = address;
        this.password = password;
    }

    //******** GETTERS AND SETTERS ***********
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
