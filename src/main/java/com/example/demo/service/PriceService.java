package com.example.demo.service;

import com.example.demo.dto.PriceSearchResponseDto;

import java.time.LocalDateTime;

public interface PriceService {

    PriceSearchResponseDto findPrice(Long productId, Long brandId, LocalDateTime applicationDate);
}
