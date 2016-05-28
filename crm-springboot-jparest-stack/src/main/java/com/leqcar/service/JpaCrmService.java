package com.leqcar.service;

import com.leqcar.domain.Customer;
import com.leqcar.domain.ProfilePhoto;
import com.leqcar.domain.User;
import com.leqcar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by jongtenerife on 23/05/2016.
 */
@Service
public class JpaCrmService implements CrmService {

    UserRepository userRepository;

    @Autowired
    public JpaCrmService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ProfilePhoto readUserProfile(long userId) {
        return null;
    }

    @Override
    public void writeUserProfilePhoto(long userId, MediaType mediaType, byte[] bytesForProfilePhoto) {

    }

    @Override
    public User findById(long userId) {
        return userRepository.getOne(userId);
    }

    @Override
    public User createUser(String username, String password, String firstName, String lastName) {
        return null;
    }

    @Override
    public User removeUser(long userId) {
        return null;
    }

    @Override
    public User updateUser(long userId, String username, String password, String firstName, String lastName) {
        return null;
    }

    @Override
    public User findUserByUsername(String username) {
        return null;
    }

    @Override
    public Customer removeAccount(long userId, long customerId) {
        return null;
    }

    @Override
    public Customer addAccount(long userId, String firstName, String lastName) {
        return null;
    }

    @Override
    public Collection<Customer> loadCustomerAccounts(long userId) {
        return null;
    }

    @Override
    public Customer findCustomerById(long customerId) {
        return null;
    }
}
