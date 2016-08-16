package com.leqcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leqcar.domain.Account;

/**
 * Created by jongtenerife on 08/05/2016.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

    Account findByAccountNumber(String accountNumber);

}
