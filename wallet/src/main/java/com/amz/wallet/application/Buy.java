package com.amz.wallet.application;

import com.amz.wallet.domain.Wallet;
import com.amz.wallet.domain.Wallets;
import com.amz.wallet.infra.db.WalletConfig;
import com.amz.wallet.persentation.BuyRequestDto;
import com.amz.wallet.persentation.BuyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Buy {

    private final Wallets wallets;
    private final WalletConfig config;

    public BuyResponse applyAmount(BuyRequestDto request) {
        Wallet wallet = wallets.getById(request.getWalletId())
                .orElseThrow(() -> new WalletNotFoundException(config.getNotFountMessage()));

        boolean hasEnoughMoney = wallet.hasEnoughMoney(request.getSourceAmount());

        if (Boolean.FALSE.equals(hasEnoughMoney)) {
            throw new NotEnoughMoneyException("you have not enough money");
        }

        wallet.addAmount(request.getTargetAmount());
        wallets.save(wallet);


        return null;
    }
}
