package com.amz.wallet.domain;

import com.amz.wallet.persentation.dto.Currency;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Getter
public class Wallet {

    private final Map<Currency, BigDecimal> amountBaseOnCurrency;

    public Wallet() {
        amountBaseOnCurrency = new ConcurrentHashMap<>();
    }


    public boolean hasEnoughMoney(BigDecimal sourceAmount, Currency sourceCurrency) {
        return amountBaseOnCurrency.containsKey(sourceCurrency) &&
                amountBaseOnCurrency.get(sourceCurrency).compareTo(sourceAmount) >= 0;
    }

    //todo read this logic
    public void apply(BigDecimal targetAmount, Currency targetCurrency,
                      Currency sourceCurrency, BigDecimal sourceAmount) {
        if (!amountBaseOnCurrency.containsKey(targetCurrency) && amountBaseOnCurrency.containsKey(sourceCurrency)) {
            throw new IllegalArgumentException("wrong target currency");
        }

        amountBaseOnCurrency.computeIfPresent(sourceCurrency, (_, currentAmount) -> currentAmount.subtract(sourceAmount));
        amountBaseOnCurrency.merge(targetCurrency, targetAmount, BigDecimal::add);
    }


}
