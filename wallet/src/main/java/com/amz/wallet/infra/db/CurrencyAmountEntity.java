package com.amz.wallet.infra.db;

import com.amz.wallet.persentation.dto.Currency;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class CurrencyAmountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "currency_seq_gen")
    @SequenceGenerator(name = "currency_seq_gen", sequenceName = "currency_id_seq", allocationSize = 10)
    private Long id;

    private Currency currency;

    private BigDecimal amount;
}
