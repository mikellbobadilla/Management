package com.ar.mikellbobadilla.app.category;

import com.ar.mikellbobadilla.app.exceptions.ResourceException;
import com.ar.mikellbobadilla.app.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Override
    public List<Category> getAllCategories() {
        return repository.findAll(Sort.by("name").ascending());
    }

    @Override
    public Category getCategory(Integer categoryId) {
        return repository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

    @Override
    public Category createCategory(CategoryRequest request) {

        if (repository.existsByNameIgnoreCase(request.name())) {
            throw new ResourceException("Category name exists. Try again");
        }

        Category newCategory = Category.builder()
                .name(request.name())
                .build();

        return repository.save(newCategory);
    }

    @Override
    public Category updateCategory(Integer categoryId, CategoryRequest request) {

        if (repository.existsByNameIgnoreCaseAndIdNot(request.name(), categoryId)) {
            throw new ResourceException("Category name exists. Try again");
        }

        Category category = repository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        category.setName(request.name());

        return repository.save(category);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        repository.deleteById(categoryId);
    }
}
