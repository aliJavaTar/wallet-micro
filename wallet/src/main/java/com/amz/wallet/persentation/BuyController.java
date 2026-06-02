package com.amz.wallet.persentation;

import com.amz.wallet.application.Buy;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/buy")
@RequiredArgsConstructor
@Validated
public class BuyController {

    private final Buy buy;

    @PostMapping
    public ResponseEntity<BuyResponse> buy(@RequestBody @Valid BuyRequestDto request) {
        return ResponseEntity.ok(buy.applyAmount(request));
    }


}
