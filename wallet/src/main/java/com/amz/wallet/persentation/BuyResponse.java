package com.amz.wallet.persentation;

import java.math.BigDecimal;


public record BuyResponse(String resultMessage, String trackingCode, BigDecimal newAmount) {
}
