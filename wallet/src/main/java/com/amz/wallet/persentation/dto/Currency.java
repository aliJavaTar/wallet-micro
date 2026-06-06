package com.amz.wallet.persentation.dto;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
public enum Currency {
    IRR((short) 1),
    USD((short) 2),
    EURO((short) 3);

    private final short value;

    private static final Map<Short, Currency> VALUE_MAP = Arrays.stream(values())
            .collect(Collectors.toMap(Currency::getValue, Function.identity()));

    Currency(short value) {
        this.value = value;
    }

    public static Currency getValue(short value) {
        return Optional.ofNullable(VALUE_MAP.get(value))
                .orElseThrow(() -> new IllegalArgumentException("Currency value " + value + " not supported"));
    }
}
