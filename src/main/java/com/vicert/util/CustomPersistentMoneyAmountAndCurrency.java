package com.vicert.util;

import org.jadira.usertype.moneyandcurrency.legacyjdk.columnmapper.BigDecimalBigDecimalColumnMapper;
import org.jadira.usertype.spi.shared.AbstractMultiColumnUserType;
import org.jadira.usertype.spi.shared.ColumnMapper;
import org.javamoney.moneta.Money;

import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;
import java.math.BigDecimal;

/**
 * Created by petrovicu on 22/07/2018.
 */
public class CustomPersistentMoneyAmountAndCurrency extends AbstractMultiColumnUserType<MonetaryAmount> {

    private static final ColumnMapper<?, ?>[] COLUMN_MAPPERS = new ColumnMapper<?, ?>[]{new CustomStringColumnCurrencyUnitMapper(),
            new BigDecimalBigDecimalColumnMapper()};

    private static final String[] PROPERTY_NAMES = new String[]{"currency", "number"};

    @Override
    protected ColumnMapper<?, ?>[] getColumnMappers() {
        return COLUMN_MAPPERS;
    }

    @Override
    protected Money fromConvertedColumns(Object[] convertedColumns) {

        CurrencyUnit currencyUnitPart = (CurrencyUnit) convertedColumns[0];
        BigDecimal amountPart = (BigDecimal) convertedColumns[1];
        return Money.of(amountPart, currencyUnitPart);
    }

    @Override
    protected Object[] toConvertedColumns(MonetaryAmount value) {
        return new Object[]{value.getCurrency(), value.getNumber().numberValue(BigDecimal.class)};
    }

    @Override
    public String[] getPropertyNames() {
        return PROPERTY_NAMES;
    }
}
