package com.ar.mikellbobadilla.app.category;

import java.util.List;

public record CategoryResponse(
        Integer id,
        String name,
        List<SubcategoryResponse> subcategories
) {
}
