package com.leqcar.domain;

import com.leqcar.common.Money;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jongtenerife on 14/05/2016.
 */
@Entity
@Table(name = "T_REWARD")
public class Reward {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="confirmation_number")
    private String confirmationNumber;

    @Embedded
    @AttributeOverride(name = "value", column=@Column(name = "reward_points"))
    private RewardPoints rewardPoints;

    @Embedded
    @AttributeOverride(name = "number", column=@Column(name = "merchant_number"))
    private MerchantDetails merchantDetails;

    @Embedded
    @AttributeOverride(name = "acctNumber", column=@Column(name = "account_number"))
    private AccountDetails accountDetails;

    @Embedded
    @AttributeOverride(name = "number", column=@Column(name = "card_number"))
    private CardDetails cardDetails;

    @Column(name = "reward_date")
    private Date rewardDate;

    @Column(name = "purchase_amount")
    private Money purchaseAmount;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    public Reward() { //for JPA
    }

    public Reward(String confirmationNumber, RewardPoints rewardPoints, Date rewardDate, Money purchaseAmount, Date purchaseDate) {
        this.confirmationNumber = confirmationNumber;
        this.rewardPoints = rewardPoints;
        this.rewardDate = rewardDate;
        this.purchaseAmount = purchaseAmount;
        this.purchaseDate = purchaseDate;
    }

    public Reward(Long id, String confirmationNumber, RewardPoints rewardPoints, MerchantDetails merchantDetails, AccountDetails accountDetails, CardDetails cardDetails, Date rewardDate, Money purchaseAmount, Date purchaseDate) {
        this.id = id;
        this.confirmationNumber = confirmationNumber;
        this.rewardPoints = rewardPoints;
        this.merchantDetails = merchantDetails;
        this.accountDetails = accountDetails;
        this.cardDetails = cardDetails;
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

    public Long getId() {
        return id;
    }

    public MerchantDetails getMerchantDetails() {
        return merchantDetails;
    }

    public void setMerchantDetails(MerchantDetails merchantDetails) {
        this.merchantDetails = merchantDetails;
    }

    public AccountDetails getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(AccountDetails accountDetails) {
        this.accountDetails = accountDetails;
    }

    public CardDetails getCardDetails() {
        return cardDetails;
    }

    public void setCardDetails(CardDetails cardDetails) {
        this.cardDetails = cardDetails;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Reward{" +
                "id=" + id +
                ", confirmationNumber='" + confirmationNumber + '\'' +
                ", rewardPoints=" + rewardPoints +
                ", merchantDetails=" + merchantDetails +
                ", accountDetails=" + accountDetails +
                ", cardDetails=" + cardDetails +
                ", rewardDate=" + rewardDate +
                ", purchaseAmount=" + purchaseAmount +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
