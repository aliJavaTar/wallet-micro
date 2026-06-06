package com.amz.wallet.infra.db;

import com.amz.wallet.persentation.dto.Currency;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Optional;

@Converter(autoApply = true)
public class CurrencyConvertor implements AttributeConverter<Currency, Short> {
    @Override
    public Short convertToDatabaseColumn(Currency attribute) {
        return Optional.ofNullable(attribute).map(Currency::getValue).orElse(null);
    }

    @Override
    public Currency convertToEntityAttribute(Short number) {
        return Currency.getValue(number);
    }
}
