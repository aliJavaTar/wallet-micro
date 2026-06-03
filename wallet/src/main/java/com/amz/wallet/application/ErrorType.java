package com.amz.wallet.application;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorType {
    WALLET_NOT_FOUND(1001, "wallet.not-found", HttpStatus.NOT_FOUND),
    INSUFFICIENT_ACCOUNT_BALANCE(1002, "wallet.insufficient-balance", HttpStatus.BAD_REQUEST);

    private final int errorCode;
    private final HttpStatus httpStatus;
    private final String key;

    ErrorType(int errorCode, String key, HttpStatus httpStatus) {
        this.errorCode = errorCode;
        this.key = key;
        this.httpStatus = httpStatus;
    }
}
