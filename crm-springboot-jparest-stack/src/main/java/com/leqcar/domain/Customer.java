package com.leqcar.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by jongtenerife on 22/05/2016.
 */
@Entity
@Table(name ="customer")
public class Customer implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -3515429299577755656L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = true, name = "customer_user_id_fkey")
    private User user;

    @Column(name = "signup_date")
    private Date signupDate;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @JsonProperty
    Long getDatabaseId() {
        return this.id;
    }

    public Customer() { //for JPA
    }

    public Customer(Customer c) {
        this(new User(c.user), c);
    }

    public Customer(User user, Customer customer) {
        this.id = customer.id;
        this.user = user;
        this.signupDate = customer.signupDate;
        this.firstName = customer.firstName;
        this.lastName = customer.lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(Date signupDate) {
        this.signupDate = signupDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
