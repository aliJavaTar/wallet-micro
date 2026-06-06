package com.amz.wallet.persentation.dto;

import java.math.BigDecimal;


public record BuyResponse(String resultMessage, String trackingCode, BigDecimal newAmount) {
}
