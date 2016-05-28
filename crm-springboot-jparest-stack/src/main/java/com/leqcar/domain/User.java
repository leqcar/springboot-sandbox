package com.leqcar.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jongtenerife on 22/05/2016.
 */
@Entity
@Table(name = "user_account")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Customer> customers = new HashSet<>();

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "profile_photo_media_type" )
    private String profilePhotoMediaType;

    @Column(name = "user_name")
    private String username;

    @Column(name = "pass_word")
    private String password;

    @Column(name = "profile_photo_imported")
    private boolean profilePhotoImported;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "signup_date")
    private Date signupDate;

    public User() { //for JPA
    }

    public User(Long id) {
        this.id = id;
    }

    public User(User user) {
        this(user, new HashSet<Customer>());
    }

    public User(User usr, Set<Customer> customerCollections) {
        this(usr.getId(), usr.getPassword(), usr.getFirstName(), usr.getLastName());
    }

    public User(Long id, String username, String firstName, String lastName) {
        this(username, null, firstName, lastName);
        this.id = id;
    }

    public User(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.signupDate = new Date();
        this.enabled = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
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

    public String getProfilePhotoMediaType() {
        return profilePhotoMediaType;
    }

    public void setProfilePhotoMediaType(String profilePhotoMediaType) {
        this.profilePhotoMediaType = profilePhotoMediaType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isProfilePhotoImported() {
        return profilePhotoImported;
    }

    public void setProfilePhotoImported(boolean profilePhotoImported) {
        this.profilePhotoImported = profilePhotoImported;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(Date signupDate) {
        this.signupDate = signupDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }
}
