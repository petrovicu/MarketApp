package com.vicert.domain;

import javax.persistence.*;

/**
 * Created by petrovicu on 19/07/2018.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "orderLineSeq")
@Table(name = "ORDER_LINES")
public class OrderLine extends BaseEntity {

    private int quantity;

    @Column(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "product_id", nullable = false)
    private Product product;

    //******** GETTERS AND SETTERS ***********
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
