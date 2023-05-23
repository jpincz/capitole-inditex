package com.example.demo.service;

import com.example.demo.dto.PriceSearchResponseDto;
import com.example.demo.exception.PriceNotFoundException;
import com.example.demo.model.Price;
import com.example.demo.repository.PriceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    @Override
    public PriceSearchResponseDto findPrice(Long productId, Long brandId, LocalDateTime applicationDate) {
        Price price = priceRepository.findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                        productId,
                        brandId,
                        applicationDate,
                        applicationDate)
                .orElseThrow(() -> new PriceNotFoundException("No price found for the given parameters"));
        return PriceSearchResponseDto.from(price);
    }
}
