package com.amz.wallet.infra.db.config;

import com.amz.wallet.application.ApplicationException;
import com.amz.wallet.application.ErrorType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExceptionFactory {

    private final ErrorMessageProperties errorMessageProperties;

    public ApplicationException of(ErrorType errorType) {
        return new ApplicationException(
                errorType,
                errorMessageProperties.getErrorMessage(errorType.getKey())
        );
    }
}
