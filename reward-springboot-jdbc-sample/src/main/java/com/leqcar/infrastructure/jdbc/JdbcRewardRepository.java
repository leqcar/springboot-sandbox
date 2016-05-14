package com.leqcar.infrastructure.jdbc;

import com.leqcar.domain.Account;
import com.leqcar.domain.Reward;
import com.leqcar.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by jongtenerife on 14/05/2016.
 */
@Component
public class JdbcRewardRepository implements RewardRepository {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    private static final String SQL_INSERT_REWARD =
            "INSERT INTO T_REWARD (confirmation_number, reward_points, reward_date, account_number, card_number, merchant_number, purchase_amount, purchase_date)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_NEXT_CONFIRMATION_NUMBER =
            "select next value for S_REWARD_CONFIRMATION_NUMBER from DUAL_REWARD_CONFIRMATION_NUMBER";

    @Autowired
    public JdbcRewardRepository(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String confirmReward(Account account, String cardNumber, String merchantNumber, Reward reward) {

        String nextConfirmationNumber = nextConfirmationNumber();

        jdbcTemplate.update(SQL_INSERT_REWARD,
                nextConfirmationNumber,
                reward.getRewardPoints().getValue().doubleValue(),
                reward.getRewardDate(),
                account.getNumber(),
                cardNumber,
                merchantNumber,
                reward.getPurchaseAmount().getValue().doubleValue(),
                reward.getPurchaseDate());

        return nextConfirmationNumber;
    }

    private String nextConfirmationNumber() {
        return jdbcTemplate.queryForObject(SQL_NEXT_CONFIRMATION_NUMBER, String.class);
    }

}
