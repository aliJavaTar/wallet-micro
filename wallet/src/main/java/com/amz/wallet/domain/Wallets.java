package com.amz.wallet.domain;

import java.util.Optional;

public interface Wallets {
    Optional<Wallet> getById(long id);

    void save(Wallet wallet);
}
