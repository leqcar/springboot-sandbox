package com.leqcar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.leqcar.domain.User;

/**
 * Created by jongtenerife on 22/05/2016.
 */

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(@Param("username") String username);

    List<User> findUsersByFirstNameOrLastNameOrUsername(
            @Param("firstname") String firstName,
            @Param("lastname") String lastName,
            @Param("username") String username);
}
