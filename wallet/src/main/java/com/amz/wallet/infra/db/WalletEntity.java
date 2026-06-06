package com.amz.wallet.infra.db;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Entity
public class WalletEntity {

    @Id
    private Long id;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<CurrencyAmountEntity> currencies;

   //wallet_id  amount    currency_ID
   // 1             12     ( 1 )      USD
  // 1              1      ( 2 )     Rial
}
