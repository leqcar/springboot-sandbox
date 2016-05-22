package com.leqcar.repository;

import com.leqcar.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by jongtenerife on 22/05/2016.
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByUsername(@Param("username") String username);

    List<User> findUsersByFirstNameOrLastNameOrUsername(
            @Param("firstname") String firstName,
            @Param("lastname") String lastName,
            @Param("username") String username);
}
