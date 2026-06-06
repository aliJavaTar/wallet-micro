package com.amz.wallet.infra.db;

import com.amz.wallet.domain.Wallet;
import com.amz.wallet.domain.Wallets;
import com.amz.wallet.infra.db.mapper.WalletMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class WalletsImpl implements Wallets {

    private final WalletJpaRepository repository;
    private final WalletMapper walletMapper;


    @Override
    public Optional<Wallet> getById(long id) {
        return repository.findById(id).map(walletMapper::toDomain);
    }

    @Override
    public void save(Wallet wallet) {
        repository.save(new WalletEntity());
    }
}
