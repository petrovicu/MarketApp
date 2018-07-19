package com.vicert.domain;

import org.javamoney.moneta.Money;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by petrovicu on 19/07/2018.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "prodSeq")
@Table(name = "PRODUCTS")
public class Product extends BaseEntity {

    @Column(name = "ref_id", nullable = false)
    private UUID refId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Money price;

    //******** GETTERS AND SETTERS ***********
    public UUID getRefId() {
        return refId;
    }

    public void setRefId(UUID refId) {
        this.refId = refId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }
}
