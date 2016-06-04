package com.leqcar.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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


    public Account() { //for JPA
    }

    public Account(String name, BigDecimal totalPoints) {
        this.name = name;
        this.totalPoints = totalPoints;

    }

    public String getName() {
        return name;
    }

    public BigDecimal getTotalPoints() {
        return totalPoints;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", totalPoints="
				+ totalPoints + "]";
	}

}
