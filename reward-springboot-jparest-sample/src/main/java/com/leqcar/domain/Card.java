package com.leqcar.domain;

import javax.persistence.*;

/**
 * Created by jongtenerife on 13/05/2016.
 */
@Entity
@Table(name = "T_ACCOUNT_CARD")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private CardDetails cardDetails;


    public Card(String number) {
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException("Card number cannot be null");
        }
        this.cardDetails = new CardDetails();
        this.cardDetails.setNumber(number);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CardDetails getCardDetails() {
        return cardDetails;
    }

    public void setCardDetails(CardDetails cardDetails) {
        this.cardDetails = cardDetails;
    }

    public Card() { //for JPA
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardDetails=" + cardDetails +
                '}';
    }
}
