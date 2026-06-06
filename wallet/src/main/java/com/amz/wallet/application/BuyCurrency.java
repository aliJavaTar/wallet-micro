package com.amz.wallet.application;

import com.amz.wallet.domain.Wallet;
import com.amz.wallet.domain.Wallets;
import com.amz.wallet.infra.db.config.ExceptionFactory;
import com.amz.wallet.persentation.dto.BuyRequestDto;
import com.amz.wallet.persentation.dto.BuyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BuyCurrency {

    private final Wallets wallets;
    private final ExceptionFactory walletException;

    @Transactional
    public BuyResponse applyAmount(BuyRequestDto request) {
        Wallet wallet = wallets.getById(request.getWalletId())
                .orElseThrow(() -> walletException.of(ErrorType.WALLET_NOT_FOUND));

        if (!wallet.hasEnoughMoney(request.getSourceAmount(), request.getSourceCurrency())) {
            throw walletException.of(ErrorType.INSUFFICIENT_ACCOUNT_BALANCE);
        }

        wallet.apply(request.getTargetAmount(), request.getTargetCurrency(),
                request.getSourceCurrency(), request.getSourceAmount());

        wallets.save(wallet);

        return new BuyResponse("", "", null);
    }
}
