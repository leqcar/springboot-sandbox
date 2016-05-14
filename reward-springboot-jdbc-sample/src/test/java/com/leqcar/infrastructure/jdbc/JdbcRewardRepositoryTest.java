package com.leqcar.infrastructure.jdbc;

import com.leqcar.RewardApplication;
import com.leqcar.common.Money;
import com.leqcar.domain.Account;
import com.leqcar.domain.Reward;
import com.leqcar.domain.RewardPoints;
import com.leqcar.repository.RewardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;

/**
 * Created by jongtenerife on 14/05/2016.
 */

//TODO : Using SpringBoot 1.4.XXX, try using @SpringRunner, @SpringBootTest (simplified version)

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(RewardApplication.class)
public class JdbcRewardRepositoryTest {

    @Autowired
    private RewardRepository rewardRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testConfig() {

    }

    @Test
    public void testCreateReward() throws Exception {
        String accountNumber = "8861888";
        String cardNumber = "1234567890";
        String merchantNumber = "1115558888";

        Account foo = new Account(accountNumber, "Foo");
        RewardPoints pointsEarned = new RewardPoints(2.0);
        Reward reward = new Reward(null, pointsEarned, new Date(), new Money(1000.0), new Date());

        String confirmationNumber = rewardRepository.confirmReward(
                foo, cardNumber, merchantNumber, reward);
        assertThat(confirmationNumber, is(not(isEmptyString())));
        verifyInsertedReward(confirmationNumber);
    }

    private void verifyInsertedReward(String confirmationNumber) throws Exception {
        assertThat(1, is(getRowCount()));
        Map<String, Object> values = jdbcTemplate.queryForMap("SELECT * FROM T_REWARD WHERE confirmation_number = ?", confirmationNumber);

        assertThat(values.get("ACCOUNT_NUMBER"), is("8861888"));
        assertThat(values.get("CARD_NUMBER"), is("1234567890"));
        assertThat(values.get("MERCHANT_NUMBER"), is("1115558888"));
        assertThat(values.get("REWARD_POINTS"), is(2.0));
        assertThat(values.get("PURCHASE_AMOUNT"), is(1000.0));
    }

    private int getRowCount() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM T_REWARD", Integer.class);
    }

}