package com.amz.wallet.infra.db.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ConfigurationProperties(prefix = "errors")
@Getter
@Setter
public class ErrorMessageProperties {
    private final Map<String, String> messages = new ConcurrentHashMap<>();

    public String getErrorMessage(String key) {
        return messages.getOrDefault(key, "");
    }
}
