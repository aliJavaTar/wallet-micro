package com.amz.wallet.application;

public class WalletNotFoundException extends RuntimeException {
    public WalletNotFoundException(String walletNotFound) {
        super(walletNotFound);
    }
}

