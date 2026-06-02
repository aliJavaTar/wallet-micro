package com.amz.wallet.persentation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BuyResponse {
    private String resultMessage;
    private String trackingCode;
    private String redirectUrl;
    private BigDecimal newAmount;
}
