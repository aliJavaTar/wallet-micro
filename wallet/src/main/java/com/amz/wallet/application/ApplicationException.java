package com.amz.wallet.application;

import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {
    private final ErrorType errorType;

    public ApplicationException(ErrorType errorType) {
        this.errorType = errorType;
    }

    public ApplicationException(ErrorType errorType, String details) {
        super(details);
        this.errorType = errorType;

    }

}