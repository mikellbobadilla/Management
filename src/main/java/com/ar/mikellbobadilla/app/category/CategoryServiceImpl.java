package com.ar.mikellbobadilla.app.category;

import com.ar.mikellbobadilla.app.exceptions.ResourceException;
import com.ar.mikellbobadilla.app.exceptions.ResourceNotFoundException;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Override
    public List<CategoryResponse> getAllCategories() {
        var categories = repository.findAllByParentIsNull();
        return categoryResponseList(categories);
    }

    @Override
    public SubcategoryResponse createCategory(CategoryRequest request) {
        Category parent = null;

        if (repository.existsByNameIgnoreCase(request.name())) {
            throw new ResourceException("Name already exists");
        }

        if (request.parentId() != null) {
            parent = repository.findByIdAndParentIsNull(request.parentId())
                    .orElseThrow(() -> new ResourceNotFoundException("Parent not found"));
        }

        Category category = Category.builder()
                .name(request.name())
                .parent(parent)
                .build();
        return subcategoryResponse(repository.save(category));
    }

    @Transactional(rollbackFor = {})
    @Override
    public SubcategoryResponse updateCategory(Integer categoryId, CategoryRequest request) {
        Category category = repository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        Category parent = category.getParent();

        if (repository.existsByNameIgnoreCaseAndIdNot(request.name(), categoryId)) {
            throw new ResourceException("Name already exists");
        }

        if (request.parentId() != null && !Objects.equals(parent.getId(), request.parentId())) {
            parent = repository.findByIdAndParentIsNull(request.parentId())
                    .orElseThrow(() -> new ResourceNotFoundException("Parent not found"));
        }

        if (request.parentId() == null) {
            parent = null;
        }

        category.setName(request.name());
        category.setParent(parent);

        return subcategoryResponse(repository.save(category));
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        try {
            repository.deleteById(categoryId);
        } catch (DataIntegrityViolationException | ConstraintViolationException exc) {
            throw new ResourceException("Cannot delete category");
        }
    }

    private SubcategoryResponse subcategoryResponse(Category category) {
        return new SubcategoryResponse(category.getId(), category.getName());
    }

    private CategoryResponse categoryResponse(Category category) {
        var subcategories = category.getSubcategories() != null
                ? category.getSubcategories().stream().map(this::subcategoryResponse).toList()
                : new ArrayList<SubcategoryResponse>();
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                subcategories
        );
    }

    private List<CategoryResponse> categoryResponseList(List<Category> categories) {
        return categories.stream().map(this::categoryResponse).toList();
    }
}
