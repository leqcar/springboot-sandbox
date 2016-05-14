package com.leqcar.repository;

import com.leqcar.common.Money;
import com.leqcar.domain.Account;
import com.leqcar.domain.Reward;
import com.leqcar.domain.RewardPoints;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by jongtenerife on 14/05/2016.
 */
@Repository
public interface RewardRepository {

    String confirmReward(
            Account account, String cardNumber, String merchantNumber,
            Reward reward);


}
