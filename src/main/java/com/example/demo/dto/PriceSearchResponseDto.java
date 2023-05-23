package com.example.demo.dto;

import com.example.demo.model.Price;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class PriceSearchResponseDto {

    private Long brandId;
    private Long productId;
    private Integer priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal price;

    public static PriceSearchResponseDto from(Price price) {
        return PriceSearchResponseDto.builder()
                .productId(price.getProduct().getId())
                .brandId(price.getBrand().getId())
                .priceList(price.getPriceList())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .price(price.getPrice())
                .build();
    }
}
