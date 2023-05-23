package com.example.demo.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

class ProductTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    void testIdGetterAndSetter() {
        Product product = new Product();
        product.setId(1L);
        Assertions.assertThat(product.getId()).isEqualTo(1L);
    }

    @Test
    void testNameGetterAndSetter() {
        Product product = new Product();
        product.setName("Product A");
        Assertions.assertThat(product.getName()).isEqualTo("Product A");
    }

    @Test
    void testNameCannotBeNull() {
        Product product = Product.builder()
                .name(null)
                .build();
        Set<ConstraintViolation<Product>> violations = validator.validate(product);
        Assertions.assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    void testNameCannotBeEmpty() {
        Product product = Product.builder()
                .name("")
                .build();
        Set<ConstraintViolation<Product>> violations = validator.validate(product);
        Assertions.assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    void testNameCannotBeBlank() {
        Product product = Product.builder()
                .name("    ")
                .build();
        Set<ConstraintViolation<Product>> violations = validator.validate(product);
        Assertions.assertThat(violations.size()).isEqualTo(1);
    }
}
