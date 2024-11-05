package com.ar.mikellbobadilla.app.category;

import java.util.ArrayList;
import java.util.List;

public class CategoryToDTO {

    public static SubcategoryResponse subcategoryResponse(Category category) {
        return new SubcategoryResponse(category.getId(), category.getName());
    }

    public static CategoryResponse categoryResponse(Category category) {
        var subcategories = category.getSubcategories() != null
                ? category.getSubcategories().stream().map(CategoryToDTO::subcategoryResponse).toList()
                : new ArrayList<SubcategoryResponse>();
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                subcategories
        );
    }

    public static List<CategoryResponse> categoryResponseList(List<Category> categories) {
        return categories.stream().map(CategoryToDTO::categoryResponse).toList();
    }
}
