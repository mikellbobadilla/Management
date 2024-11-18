package com.ar.mikellbobadilla.app.product;

import com.ar.mikellbobadilla.app.category.Category;

import java.math.BigDecimal;
import java.util.List;

public record ProductResponse(
        Integer id,
        String name,
        String description,
        Integer stock,
        BigDecimal price,
        BigDecimal cost,
        List<Category> categories
) {
}
