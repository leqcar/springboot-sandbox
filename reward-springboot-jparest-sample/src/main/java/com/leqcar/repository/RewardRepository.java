package com.leqcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.leqcar.domain.Account;

/**
 * Created by jongtenerife on 14/05/2016.
 */
@RepositoryRestResource
public interface RewardRepository extends JpaRepository<Account, Long> {

/*    String confirmReward(
            Account account, String cardNumber, String merchantNumber,
            Reward reward);*/


}
