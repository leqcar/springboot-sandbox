package com.leqcar.domain;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

/**
 * Created by jongtenerife on 13/05/2016.
 */
@Embeddable
public class RewardPoints {
    public static final RewardPoints ZERO = new RewardPoints(BigDecimal.ZERO);

    private BigDecimal value;

    public RewardPoints(BigDecimal value) {
        if (value == null
                || (value.compareTo(BigDecimal.ZERO) < 0)) {
            throw new IllegalArgumentException(
                    "Value cannot be null, and must be greater than or equal to zero");
        }
        this.value = value;
    }

    public RewardPoints(double value) {
        this(BigDecimal.valueOf(value));
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "RewardPoints{" +
                "value=" + value +
                '}';
    }
}
