package com.amz.wallet.infra.db;

import com.amz.wallet.domain.Wallet;
import com.amz.wallet.domain.Wallets;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class WalletsImpl implements Wallets {

    private final WalletJpaRepository repository;

    public WalletsImpl(WalletJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Wallet> getById(long id) {
        return repository.findById(id)
                .map(walletEntity -> new Wallet());
    }

    @Override
    public void save(Wallet wallet) {
        repository.save(new WalletEntity());
    }
}
