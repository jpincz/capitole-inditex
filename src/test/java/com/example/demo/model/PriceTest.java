package com.example.demo.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public class PriceTest {

    private static Validator validator;

    @BeforeAll
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    private Price createValidPrice() {
        Product product = Product.builder()
                .id(1L)
                .name("Product")
                .build();

        Brand brand = Brand.builder()
                .id(1L)
                .name("Brand")
                .build();

        return Price.builder()
                .id(1L)
                .brand(brand)
                .product(product)
                .priority(1)
                .priceList(1)
                .price(new BigDecimal("99.99"))
                .startDate(LocalDateTime.of(2023, 5, 20, 0, 0))
                .endDate(LocalDateTime.of(2023, 12, 31, 23, 59))
                .currency(Currency.EUR)
                .build();
    }

    @Test
    void testSetterAndGetterForId() {
        Price price = new Price();
        price.setId(1L);
        Assertions.assertThat(price.getId()).isEqualTo(1L);
    }

    @Test
    void testSetterAndGetterForBrandId() {
        Brand brand = new Brand();
        brand.setId(1L);
        Price price = new Price();
        price.setBrand(brand);
        Assertions.assertThat(price.getBrand().getId()).isEqualTo(1L);
    }

    @Test
    void testSetterAndGetterForProductId() {
        Product product = new Product();
        product.setId(1L);
        Price price = new Price();
        price.setProduct(product);
        Assertions.assertThat(price.getProduct().getId()).isEqualTo(1L);
    }

    @Test
    void testSetterAndGetterForStartDate() {
        LocalDateTime startDate = LocalDateTime.of(2023, 5, 20, 10, 30);
        Price price = new Price();
        price.setStartDate(startDate);
        Assertions.assertThat(price.getStartDate()).isEqualTo(startDate);
    }

    @Test
    void testSetterAndGetterForEndDate() {
        LocalDateTime endDate = LocalDateTime.of(2023, 5, 20, 11, 30);
        Price price = new Price();
        price.setEndDate(endDate);
        Assertions.assertThat(price.getEndDate()).isEqualTo(endDate);
    }

    @Test
    void testSetterAndGetterForPriceList() {
        Price price = new Price();
        price.setPriceList(1);
        Assertions.assertThat(price.getPriceList()).isEqualTo(1);
    }

    @Test
    void testSetterAndGetterForPriority() {
        Price price = new Price();
        price.setPriority(1);
        Assertions.assertThat(price.getPriority()).isEqualTo(1);
    }

    @Test
    void testSetterAndGetterForPrice() {
        BigDecimal productPrice = new BigDecimal("19.99");
        Price price = new Price();
        price.setPrice(productPrice);
        Assertions.assertThat(price.getPrice()).isEqualTo(productPrice);
    }

    @Test
    void testSetterAndGetterForCurrency() {
        Price price = new Price();
        price.setCurrency(Currency.EUR);
        Assertions.assertThat(price.getCurrency()).isEqualTo(Currency.EUR);
    }

    @Test
    void testPriceListIdCannotBeNull() {
        Price price = createValidPrice();
        price.setPriceList(null);
        Set<ConstraintViolation<Price>> violations = validator.validate(price);
        Assertions.assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    void testBrandCannotBeNull() {
        Price price = createValidPrice();
        price.setBrand(null);
        Set<ConstraintViolation<Price>> violations = validator.validate(price);
        Assertions.assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    void testProductCannotBeNull() {
        Price price = createValidPrice();
        price.setProduct(null);
        Set<ConstraintViolation<Price>> violations = validator.validate(price);
        Assertions.assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    void testPriceCannotBeNull() {
        Price price = createValidPrice();
        price.setPrice(null);
        Set<ConstraintViolation<Price>> violations = validator.validate(price);
        Assertions.assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    void testStartDateCannotBeNull() {
        Price price = createValidPrice();
        price.setStartDate(null);
        Set<ConstraintViolation<Price>> violations = validator.validate(price);
        Assertions.assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    void testEndDateCannotBeNull() {
        Price price = createValidPrice();
        price.setEndDate(null);
        Set<ConstraintViolation<Price>> violations = validator.validate(price);
        Assertions.assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    void testCurrencyCannotBeNull() {
        Price price = createValidPrice();
        price.setCurrency(null);
        Set<ConstraintViolation<Price>> violations = validator.validate(price);
        Assertions.assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    void testPriorityCannotBeNull() {
        Price price = createValidPrice();
        price.setPriority(null);
        Set<ConstraintViolation<Price>> violations = validator.validate(price);
        Assertions.assertThat(violations.size()).isEqualTo(1);
    }
}



