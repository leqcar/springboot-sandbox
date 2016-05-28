package com.leqcar.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by jongtenerife on 28/05/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    private String type;
    private Value value;

    public Quote() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("Quote for the Day : %s", value);
    }
}
