package com.ar.mikellbobadilla.app.product;

import java.math.BigDecimal;

public record ProductResponse(
        Integer id,
        String name,
        String description,
        Integer stock,
        BigDecimal price,
        BigDecimal cost,
        String category
) {
}
