package com.ar.mikellbobadilla.app.product;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRequest(
        @NotBlank
        String name,
        String description,
        @Digits(fraction = 0, integer = 10)
        Integer stock,
        @DecimalMin(inclusive = false, value = "0")
        BigDecimal price,
        @DecimalMin(inclusive = false, value = "0")
        BigDecimal cost,
        @NotNull
        Integer categoryId
) {
}
