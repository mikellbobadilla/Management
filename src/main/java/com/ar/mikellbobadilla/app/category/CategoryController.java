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

    @GetMapping
    @ResponseStatus(OK)
    List<Category> getCategories() {
        return service.getAllCategories();
    }

    @GetMapping("/{categoryId}")
    @ResponseStatus(OK)
    Category getCategory(@PathVariable Integer categoryId) {
        return service.getCategory(categoryId);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    Category postCategory(@Valid @RequestBody CategoryRequest request) {
        return service.createCategory(request);
    }

    @PutMapping("/{categoryId}")
    @ResponseStatus(OK)
    Category putCategory(@PathVariable Integer categoryId, @Valid @RequestBody CategoryRequest request) {
        return service.updateCategory(categoryId, request);
    }

    @DeleteMapping("/{categoryId}")
    @ResponseStatus(NO_CONTENT)
    void deleteCategory(@PathVariable Integer categoryId) {
        service.deleteCategory(categoryId);
    }
}
