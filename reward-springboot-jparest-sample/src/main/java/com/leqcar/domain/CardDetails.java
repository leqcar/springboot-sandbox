package com.leqcar.domain;

import javax.persistence.Embeddable;

/**
 * Created by jongtenerife on 14/05/2016.
 */
@Embeddable
public class CardDetails {

    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
