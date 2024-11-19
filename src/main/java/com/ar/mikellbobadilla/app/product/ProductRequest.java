package com.ar.mikellbobadilla.app.product;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.util.List;

public record ProductRequest(
        @NotBlank
        String name,
        String description,
        @Digits(fraction = 0, integer = 10)
        @PositiveOrZero
        Integer stock,
        @DecimalMin(inclusive = false, value = "0")
        BigDecimal price,
        @DecimalMin(inclusive = false, value = "0")
        BigDecimal cost,
        @NotNull
        List<Integer> categories
) {
}
