package com.amz.wallet.infra.db.mapper;

import com.amz.wallet.domain.Wallet;
import com.amz.wallet.infra.db.CurrencyAmountEntity;
import com.amz.wallet.infra.db.WalletEntity;
import com.amz.wallet.persentation.dto.Currency;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface WalletMapper {

    @Mapping(target = "amountBaseOnCurrency", source = "currencies")
    Wallet toDomain(WalletEntity entity);

    @Mapping(target = "currencies", source = "amountBaseOnCurrency")
    WalletEntity toEntity(Wallet wallet);

    default Map<Currency, BigDecimal> mapCurrenciesToMap(Set<CurrencyAmountEntity> currencies) {
        if (currencies == null) {
            return null;
        }
        return currencies.stream().collect(Collectors.toMap(
                        CurrencyAmountEntity::getCurrency,
                        CurrencyAmountEntity::getAmount));
    }

    default Set<CurrencyAmountEntity> mapMapToCurrencies(Map<Currency, BigDecimal> map) {
        if (map == null) {
            return null;
        }
        return map.entrySet().stream()
                .map(entry -> {
                    var entity = new CurrencyAmountEntity();
                    entity.setCurrency(entry.getKey());
                    entity.setAmount(entry.getValue());
                    return entity;}).collect(Collectors.toSet());
    }

}
