package com.vicert.domain;

import com.vicert.util.CustomPersistentMoneyAmountAndCurrency;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.javamoney.moneta.Money;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Created by petrovicu on 19/07/2018.
 */
@TypeDefs(value = {
        @TypeDef(name = "moneyAmountWithCurrencyType", typeClass = CustomPersistentMoneyAmountAndCurrency.class)
})
@Entity
@Table(name = "PRODUCTS")
public class Product extends BaseEntity {

    @Column(name = "ref_id", nullable = false)
    private UUID refId;

    @Column(name = "name", nullable = false)
    private String name;

    @Basic(optional = false)
    @Columns(columns = {
            @Column(name = "money_currency", nullable = false, length = 3),
            @Column(name = "money_amount", nullable = false)
    })
    @Type(type = "moneyAmountWithCurrencyType")
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
