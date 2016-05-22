package com.leqcar.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jongtenerife on 13/05/2016.
 */
@Entity
@Table(name="T_ACCOUNT")
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private BigDecimal totalPoints;

    @Embedded
    @AttributeOverride(name="acctNumber", column=@Column(name="NUMBER"))
    private AccountDetails accountDetails;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ACCOUNT_ID")
    private Set<Card> cards = new HashSet<>();

    public Account() { //for JPA
    }

    public Account(String name, BigDecimal totalPoints, AccountDetails accountDetails) {
        this.name = name;
        this.totalPoints = totalPoints;
        this.accountDetails = accountDetails;
    }

    public void credit(RewardPoints points) {
        totalPoints = totalPoints.add(points.getValue());
    }

    public String getName() {
        return name;
    }

    public BigDecimal getTotalPoints() {
        return totalPoints;
    }

    public boolean addCard(String cardNumber) {
        return cards.add(new Card(cardNumber));
    }

    public Set<Card> getCards() {
        return Collections.unmodifiableSet(cards);
    }
}
