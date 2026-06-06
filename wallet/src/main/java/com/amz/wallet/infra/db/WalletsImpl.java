package com.amz.wallet.infra.db;

import com.amz.wallet.domain.Wallet;
import com.amz.wallet.domain.Wallets;
import com.amz.wallet.infra.db.mapper.WalletMapper;
import com.amz.wallet.persentation.dto.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class WalletsImpl implements Wallets {

    private final WalletJpaRepository repository;
    private final WalletMapper walletMapper;


    @Override
    public Optional<Wallet> getById(long id) {
        repository.findById(id)
                .map(walletEntity -> new Wallet());

    }

    @Override
    public void save(Wallet wallet) {
        repository.save(new WalletEntity());
    }
}
