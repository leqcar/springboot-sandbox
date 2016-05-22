package com.leqcar.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by jongtenerife on 14/05/2016.
 */
@Entity
@Table(name = "T_MERCHANT")
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private MerchantDetails merchantDetails;
    private String name;

    @Column(name = "amount_per_point")
    private BigDecimal amountPerPoint; // amount that earns a point

    @Column(name = "minimum_purchase_amount")
    private BigDecimal minimumAmount; // amount before earning points

    public Merchant() { //for JPA
    }

    public Merchant(MerchantDetails merchantDetails, String name, BigDecimal amountPerPoint, BigDecimal minimumAmount) {
        this.merchantDetails = merchantDetails;
        this.name = name;
        this.amountPerPoint = amountPerPoint;
        this.minimumAmount = minimumAmount;
    }
}
