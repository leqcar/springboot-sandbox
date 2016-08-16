package com.leqcar.repository;

import org.springframework.stereotype.Repository;

import com.leqcar.domain.Account;
import com.leqcar.domain.Reward;

/**
 * Created by jongtenerife on 14/05/2016.
 */
@Repository
public interface RewardRepository {

    String confirmReward(
            Account account, String cardNumber, String merchantNumber,
            Reward reward);


}
