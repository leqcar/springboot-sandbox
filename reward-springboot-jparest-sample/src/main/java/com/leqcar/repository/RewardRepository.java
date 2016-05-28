package com.leqcar.repository;

import com.leqcar.common.Money;
import com.leqcar.domain.Account;
import com.leqcar.domain.Reward;
import com.leqcar.domain.RewardPoints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by jongtenerife on 14/05/2016.
 */
@RepositoryRestResource
public interface RewardRepository extends JpaRepository<Account, Long> {

/*    String confirmReward(
            Account account, String cardNumber, String merchantNumber,
            Reward reward);*/


}
