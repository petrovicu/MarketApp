package com.vicert.util;

import org.jadira.usertype.spi.shared.AbstractStringColumnMapper;

import javax.money.CurrencyContext;
import javax.money.CurrencyUnit;

/**
 * Created by petrovicu on 22/07/2018.
 */
public class CustomStringColumnCurrencyUnitMapper extends AbstractStringColumnMapper<CurrencyUnit> {
    private static final long serialVersionUID = 4205713919952452881L;

    public CustomStringColumnCurrencyUnitMapper() {
    }

    public CurrencyUnit fromNonNullValue(String s) {
        return new CurrencyUnit() {
            @Override
            public String getCurrencyCode() {
                return s;
            }

            @Override
            public int getNumericCode() {
                return 0;
            }

            @Override
            public int getDefaultFractionDigits() {
                return 0;
            }

            @Override
            public CurrencyContext getContext() {
                return null;
            }

            @Override
            public int compareTo(CurrencyUnit o) {
                return 0;
            }
        };
    }

    public String toNonNullValue(CurrencyUnit value) {
        return value.getCurrencyCode();
    }
}
