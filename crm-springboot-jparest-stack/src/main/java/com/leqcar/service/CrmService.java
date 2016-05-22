package com.leqcar.service;

import com.leqcar.domain.Customer;
import com.leqcar.domain.ProfilePhoto;
import com.leqcar.domain.User;
import org.springframework.http.MediaType;

import java.util.Collection;

/**
 * Created by jongtenerife on 22/05/2016.
 */
public interface CrmService {

    ProfilePhoto readUserProfile(long userId);

    void writeUserProfilePhoto(long userId, MediaType mediaType, byte[] bytesForProfilePhoto);

    User findById(long userId);

    User createUser(String username, String password, String firstName, String lastName);

    User removeUser(long userId);

    User updateUser(long userId, String username, String password, String firstName, String lastName);

    User findUserByUsername(String username);

    Customer removeAccount(long userId, long customerId);

    Customer addAccount(long userId, String firstName, String lastName);

    Collection<Customer> loadCustomerAccounts(long userId);

    Customer findCustomerById(long customerId);


}
