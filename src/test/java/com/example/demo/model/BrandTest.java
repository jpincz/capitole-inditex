package com.example.demo.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

class BrandTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    void testIdGetterAndSetter() {
        Brand brand = new Brand();
        brand.setId(1L);
        Assertions.assertThat(brand.getId()).isEqualTo(1L);
    }

    @Test
    void testNameGetterAndSetter() {
        Brand brand = new Brand();
        brand.setName("ZARA");
        Assertions.assertThat(brand.getName()).isEqualTo("ZARA");
    }

    @Test
    void testNameCannotBeNull() {
        Brand brand = Brand.builder()
                .name(null)
                .build();
        Set<ConstraintViolation<Brand>> violations = validator.validate(brand);
        Assertions.assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    void testNameCannotBeEmpty() {
        Brand brand = Brand.builder()
                .name("")
                .build();
        Set<ConstraintViolation<Brand>> violations = validator.validate(brand);
        Assertions.assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    void testNameCannotBeBlank() {
        Brand brand = Brand.builder()
                .name("    ")
                .build();
        Set<ConstraintViolation<Brand>> violations = validator.validate(brand);
        Assertions.assertThat(violations.size()).isEqualTo(1);
    }
}
