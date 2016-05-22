package com.leqcar.domain;

import javax.persistence.Embeddable;

/**
 * Created by jongtenerife on 14/05/2016.
 */
@Embeddable
public class AccountDetails {
    private String acctNumber;

    public void setAcctNumber(String number) {
        this.acctNumber = number;
    }

    public String getAcctNumber() {
        return acctNumber;
    }
}
