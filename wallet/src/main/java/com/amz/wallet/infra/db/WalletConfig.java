package com.amz.wallet.infra.db;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;

@ConfigurationProperties
public class WalletConfig {
    private Environment environment;

    public String getNotFountMessage() {
        return environment.getRequiredProperty("wallet.not-found", String.class);
    }
}
