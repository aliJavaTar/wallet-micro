package com.amz.wallet.infra.db;

import com.amz.wallet.domain.Wallet;
import com.amz.wallet.domain.Wallets;
import com.amz.wallet.persentation.Currency;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

@Repository
public class WalletsImpl implements Wallets {

    private final WalletJpaRepository repository;

    public WalletsImpl(WalletJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Wallet> getById(long id) {
        WalletEntity walletEntity = repository.findById(id).get();
        Wallet wallet = new Wallet();
        Map<Currency, BigDecimal> amountBaseOnCurrency = wallet.getAmountBaseOnCurrency();
        amountBaseOnCurrency.put(walletEntity.getTargetCurrency(),walletEntity.getAmount());
        return Optional.of(wallet);
//        return repository.findById(id)
//                .map(walletEntity -> {
//                    Map<Currency, BigDecimal> amountBaseOnCurrency = wallet.getAmountBaseOnCurrency();
//                    amountBaseOnCurrency.put(walletEntity.getTargetCurrency(), walletEntity.getAmount());
//                    return wallet;
//                });
    }

    @Override
    public void save(Wallet wallet) {
        repository.save(new WalletEntity());
    }
}
