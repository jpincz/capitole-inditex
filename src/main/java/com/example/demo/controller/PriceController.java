package com.example.demo.controller;

import com.example.demo.dto.PriceSearchResponseDto;
import com.example.demo.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/prices")
@RequiredArgsConstructor
public class PriceController {

    private final PriceService priceService;

    @GetMapping("/search")
    public ResponseEntity<PriceSearchResponseDto> searchPrice(
            @RequestParam("productId") Long productId,
            @RequestParam("brandId") Long brandId,
            @RequestParam("applicationDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate) {
        PriceSearchResponseDto priceSearchResponseDto = priceService.findPrice(productId, brandId, applicationDate);
        return ResponseEntity.ok(priceSearchResponseDto);
    }
}
