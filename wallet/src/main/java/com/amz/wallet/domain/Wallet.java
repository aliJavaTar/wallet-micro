package com.amz.wallet.domain;

import java.math.BigDecimal;


public class Wallet {

    private BigDecimal amount;

    public boolean hasEnoughMoney(BigDecimal sourceAmount) {
        return amount.compareTo(sourceAmount) >= 0;
    }

    public void addAmount(BigDecimal targetAmount) {
        this.amount = targetAmount.add(amount);
    }
}
