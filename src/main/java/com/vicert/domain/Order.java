package com.vicert.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Created by petrovicu on 19/07/2018.
 */
@Entity
@Table(name = "ORDERS")
public class Order extends BaseEntity {

    @Column(name = "ref_id", nullable = false)
    private UUID refId;

    @Column(name = "customer_id", nullable = true)
    private Customer customer;

    @Column(name = "order_status_id", nullable = false)
    private String orderStatusId;

    public Order() {
    }

    //******** GETTERS AND SETTERS ***********
    public UUID getRefId() {
        return refId;
    }

    public void setRefId(UUID refId) {
        this.refId = refId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(String orderStatusId) {
        this.orderStatusId = orderStatusId;
    }
}
