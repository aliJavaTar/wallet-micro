package com.amz.wallet.application;

import com.amz.wallet.domain.Wallet;
import com.amz.wallet.domain.Wallets;
import com.amz.wallet.infra.db.config.ExceptionFactory;
import com.amz.wallet.persentation.BuyRequestDto;
import com.amz.wallet.persentation.BuyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Buy {

    private final Wallets wallets;
    private final ExceptionFactory walletException;

    public BuyResponse applyAmount(BuyRequestDto request) {
        Wallet wallet = wallets.getById(request.getWalletId())
                .orElseThrow(() -> walletException.of(ErrorType.WALLET_NOT_FOUND));

        boolean hasEnoughMoney = wallet.hasEnoughMoney(request.getSourceAmount());

        if (Boolean.FALSE.equals(hasEnoughMoney)) {
            throw walletException.of(ErrorType.INSUFFICIENT_ACCOUNT_BALANCE);
        }

        wallet.addAmount(request.getTargetAmount());
        wallets.save(wallet);


        return null;
    }
}
