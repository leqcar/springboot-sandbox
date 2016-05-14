package com.leqcar.domain;

/**
 * Created by jongtenerife on 13/05/2016.
 */
public class Card {
    private String number;

    public Card(String number) {
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException("Card number cannot be null");
        }
        // To keep things simple, no MOD-10 check is done.
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public Card() {
    }

    @Override
    public String toString() {
        return "Card{" +
                "number='" + number + '\'' +
                '}';
    }
}
