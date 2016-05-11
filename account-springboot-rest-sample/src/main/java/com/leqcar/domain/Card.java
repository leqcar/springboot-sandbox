package com.leqcar.domain;

import javax.persistence.*;

import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString;

/**
 * Created by jongtenerife on 08/05/2016.
 */
@Entity
@Access(AccessType.FIELD)
public class Card {

    @Id
    @GeneratedValue
    private Long id;
    private String number;

    public Card(String number) {
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException("Card number cannot be null");
        }
        // To keep things simple, no MOD-10 check is done.
        this.number = number;
    }

    public Card() {
        //for persistence
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return reflectionToString(this);
    }
}
