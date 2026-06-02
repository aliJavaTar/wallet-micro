package com.amz.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WalletApplication {

    public static void main(String[] args) {
        SpringApplication.run(WalletApplication.class, args);
    }
}
/*

base on your cash
how much can you buy
(calculate base from on currency)
and show it

do you have enough money ?
if not you can not buy

if you buy update your wallet amount

block this amount until verify your payment

and add new currency to your amount

 */