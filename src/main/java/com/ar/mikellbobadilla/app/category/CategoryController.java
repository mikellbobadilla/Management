package com.ar.mikellbobadilla.app.category;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @ResponseStatus(OK)
    @GetMapping
    List<CategoryResponse> getAll() {
        return service.getAllCategories();
    }

    @ResponseStatus(CREATED)
    @PostMapping
    SubcategoryResponse postCategory(@Valid @RequestBody CategoryRequest request) {
        return service.createCategory(request);
    }

    @ResponseStatus(OK)
    @PutMapping("/{categoryId}")
    SubcategoryResponse putCategory(@PathVariable Integer categoryId, @Valid @RequestBody CategoryRequest request) {
        return service.updateCategory(categoryId, request);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/{categoryId}")
    void deleteCategory(@PathVariable Integer categoryId) {
        service.deleteCategory(categoryId);
    }
}
