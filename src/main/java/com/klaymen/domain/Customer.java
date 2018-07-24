package com.klaymen.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Created by petrovicu on 19/07/2018.
 */
@Entity
@Table(name = "CUSTOMERS")
public class Customer extends BaseEntity {

    @Column(name = "ref_id", nullable = false)
    private UUID refId;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "password", nullable = false)
    private String password;

    public Customer() {
    }

    public Customer(String email, String address, String password) {
        this.email = email;
        this.address = address;
        this.password = password;
    }

    //******** GETTERS AND SETTERS ***********
    public UUID getRefId() {
        return refId;
    }

    public void setRefId(UUID refId) {
        this.refId = refId;
    }

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
