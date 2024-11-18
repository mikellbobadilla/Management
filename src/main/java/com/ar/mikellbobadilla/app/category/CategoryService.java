package com.ar.mikellbobadilla.app.category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    Category getCategory(Integer categoryId);

    Category createCategory(CategoryRequest request);

    Category updateCategory(Integer categoryId, CategoryRequest request);

    void deleteCategory(Integer categoryId);
}
