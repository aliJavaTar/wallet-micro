package com.amz.wallet.persentation.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BuyRequestDto {

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Amount must be greater than 0")
    @Digits(integer = 18, fraction = 8, message = "Amount format is invalid")
    private BigDecimal sourceAmount;

    @NotBlank(message = "Currency is required")
    private Currency sourceCurrency;

    @NotBlank(message = "Target currency is required")
    private Currency targetCurrency;

    @NotNull(message = "Target amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Target amount must be greater than 0")
    @Digits(integer = 18, fraction = 8, message = "Target amount format is invalid")
    private BigDecimal targetAmount;

    @Positive(message = "Wallet ID must be greater than 0")
    private long walletId;

}
