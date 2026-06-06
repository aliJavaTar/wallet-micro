package com.amz.wallet.infra.db.mapper;

import com.amz.wallet.domain.Wallet;
import com.amz.wallet.infra.db.WalletEntity;
import org.mapstruct.Mapper;

@Mapper
public interface WalletMapper {

    WalletEntity toJpaEntity(Wallet wallet);
}
