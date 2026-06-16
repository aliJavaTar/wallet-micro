package com.amz.wallet.infra.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "wallets")
public class WalletEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wallet_seq_gen")
    @SequenceGenerator(name = "wallet_seq_gen", sequenceName = "wallet_id_seq", allocationSize = 10)
    private Long id;

    @JoinColumn(referencedColumnName = "wlllet_id")
    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<CurrencyAmountEntity> currencies;

}
