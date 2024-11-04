package com.ar.mikellbobadilla.app.category;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAllCategories();

    SubcategoryResponse createCategory(CategoryRequest request);

    SubcategoryResponse updateCategory(Integer categoryId, CategoryRequest request);

    void deleteCategory(Integer categoryId);
}
