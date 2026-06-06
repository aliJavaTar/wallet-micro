package com.amz.wallet.persentation;

import com.amz.wallet.application.BuyCurrency;
import com.amz.wallet.persentation.dto.BuyRequestDto;
import com.amz.wallet.persentation.dto.BuyResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
@Validated
public class BuyController {

    private final BuyCurrency buy;

    @PostMapping
    public ResponseEntity<BuyResponse> buy(@RequestBody @Valid BuyRequestDto request) {
        return ResponseEntity.ok(buy.applyAmount(request));
    }


}
