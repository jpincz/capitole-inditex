package com.example.demo.controller;

import com.example.demo.dto.PriceSearchResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testPriceNotFound() {
        LocalDateTime dateTime = LocalDateTime.of(2023, 6, 14, 10, 0);

        ResponseEntity<PriceSearchResponseDto> response = searchPrice(Long.MAX_VALUE, 1L, dateTime);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testPriceAtTenOnFourteenthOfJuneWithInitialData() {
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);

        ResponseEntity<PriceSearchResponseDto> response = searchPrice(35455L, 1L, applicationDate);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        PriceSearchResponseDto priceSearchResponseDto = response.getBody();

        Assertions.assertNotNull(priceSearchResponseDto);
        assertEquals(35455, priceSearchResponseDto.getProductId());
        assertEquals(1, priceSearchResponseDto.getBrandId());
        assertEquals(new BigDecimal("35.50"), priceSearchResponseDto.getPrice());
    }

    @Test
    public void testPriceAtSixteenOnFourteenthOfJuneWithInitialData() {
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 16, 0);

        ResponseEntity<PriceSearchResponseDto> response = searchPrice(35455L, 1L, applicationDate);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        PriceSearchResponseDto priceSearchResponseDto = response.getBody();

        Assertions.assertNotNull(priceSearchResponseDto);
        assertEquals(35455L, priceSearchResponseDto.getProductId());
        assertEquals(1L, priceSearchResponseDto.getBrandId());
        assertEquals(new BigDecimal("25.45"), priceSearchResponseDto.getPrice());
    }

    @Test
    public void testPriceAtTwentyOneOnFourteenthOfJuneWithInitialData() {
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 21, 0);

        ResponseEntity<PriceSearchResponseDto> response = searchPrice(35455L, 1L, applicationDate);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        PriceSearchResponseDto priceSearchResponseDto = response.getBody();

        Assertions.assertNotNull(priceSearchResponseDto);
        assertEquals(35455L, priceSearchResponseDto.getProductId());
        assertEquals(1L, priceSearchResponseDto.getBrandId());
        assertEquals(new BigDecimal("35.50"), priceSearchResponseDto.getPrice());
    }

    @Test
    public void testPriceAtTenOnFifteenthOfJuneWithInitialData() {
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 15, 10, 0);

        ResponseEntity<PriceSearchResponseDto> response = searchPrice(35455L, 1L, applicationDate);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        PriceSearchResponseDto priceSearchResponseDto = response.getBody();

        Assertions.assertNotNull(priceSearchResponseDto);
        assertEquals(35455L, priceSearchResponseDto.getProductId());
        assertEquals(1L, priceSearchResponseDto.getBrandId());
        assertEquals(new BigDecimal("30.50"), priceSearchResponseDto.getPrice());
    }

    @Test
    public void testPriceAtTwentyOneOnSixteenthOfJuneWithInitialData() {
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 16, 21, 0);

        ResponseEntity<PriceSearchResponseDto> response = searchPrice(35455L, 1L, applicationDate);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        PriceSearchResponseDto priceSearchResponseDto = response.getBody();

        Assertions.assertNotNull(priceSearchResponseDto);
        assertEquals(35455L, priceSearchResponseDto.getProductId());
        assertEquals(1L, priceSearchResponseDto.getBrandId());
        assertEquals(new BigDecimal("38.95"), priceSearchResponseDto.getPrice());
    }

    private ResponseEntity<PriceSearchResponseDto> searchPrice(Long productId, Long brandId, LocalDateTime applicationDate) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:" + port + "/api/prices/search")
                .queryParam("productId", productId)
                .queryParam("brandId", brandId)
                .queryParam("applicationDate", applicationDate);

        return restTemplate.getForEntity(
                builder.toUriString(),
                PriceSearchResponseDto.class);
    }

}
