package com.leqcar.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

/**
 * Created by jongtenerife on 14/05/2016.
 */
public class Money implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4268455739797968549L;

	public static final String DEFAULT_CURRENCY = "USD";

    private String currency;
    private BigDecimal value;

    public Money(BigDecimal value) {
        this(DEFAULT_CURRENCY, value);
    }

    public Money(double value) {
        this(DEFAULT_CURRENCY, value);
    }

    public Money(String currency, BigDecimal value) {
        super();
        initCurrency(currency);
        initValue(value);
    }

    public Money(String currency, double value) {
        this(currency, BigDecimal.valueOf(value));
    }

    public Money(Currency currency, BigDecimal value) {
        if (currency == null) {
            throw new IllegalArgumentException("Currency cannot be null");
        }
        initCurrency(currency.getCurrencyCode());
        initValue(value);
    }

    public Money(Currency currency, double value) {
        this(currency, BigDecimal.valueOf(value));
    }

    private void initCurrency(String currency) {
        if (currency == null || currency.isEmpty()) {
            throw new IllegalArgumentException("Currency cannot be null or empty");
        }
        this.currency = currency;
    }

    private void initValue(BigDecimal value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        this.value = value.setScale(2, RoundingMode.HALF_EVEN);
    }

    public Money add(Money amount) {
        assertCurrenciesMatch(amount);
        return new Money(
                this.currency,
                this.value.add(amount.value));
    }

    public Money subtract(Money amount) {
        assertCurrenciesMatch(amount);
        return new Money(
                this.currency,
                this.value.subtract(amount.value));
    }

    private void assertCurrenciesMatch(Money amount) {
        if (!this.currency.equals(amount.currency)) {
            throw new IllegalArgumentException(
                    "Currencies must match: "
                            + this.currency
                            + " vs. " + amount.currency);
        }
    }

    public Money multiplyBy(BigDecimal value) {
        return new Money(
                this.currency, this.value.multiply(value));
    }

    public Money multiplyBy(double value) {
        return multiplyBy(BigDecimal.valueOf(value));
    }

    public Money divideBy(BigDecimal value) {
        return new Money(
                this.currency, this.value.divide(value));
    }

    public Money divideBy(double value) {
        return divideBy(BigDecimal.valueOf(value));
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Money [currency=");
        builder.append(currency);
        builder.append(", value=");
        builder.append(value);
        builder.append("]");
        return builder.toString();
    }
}
