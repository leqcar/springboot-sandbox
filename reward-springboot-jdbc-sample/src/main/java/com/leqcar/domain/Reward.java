package com.leqcar.domain;

import java.util.Date;

import com.leqcar.common.Money;

/**
 * Created by jongtenerife on 14/05/2016.
 */
public class Reward {

    private String confirmationNumber;
    private RewardPoints rewardPoints;
    private Date rewardDate;
    private Money purchaseAmount;
    private Date purchaseDate;

    public Reward(String confirmationNumber, RewardPoints rewardPoints, Date rewardDate, Money purchaseAmount, Date purchaseDate) {
        this.confirmationNumber = confirmationNumber;
        this.rewardPoints = rewardPoints;
        this.rewardDate = rewardDate;
        this.purchaseAmount = purchaseAmount;
        this.purchaseDate = purchaseDate;
    }

    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public RewardPoints getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(RewardPoints rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public Date getRewardDate() {
        return rewardDate;
    }

    public void setRewardDate(Date rewardDate) {
        this.rewardDate = rewardDate;
    }

    public Money getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(Money purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
