package com.ar.mikellbobadilla.app.product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ar.mikellbobadilla.app.utils.PaginatedResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    
    private final ProductService service;

    @GetMapping
    @ResponseStatus(OK)
    PaginatedResponse<ProductResponse> getAllProducts(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(required = false) String keyword
    ) {
        return service.getAllProducts(page, size, keyword);
    }
    
    @GetMapping("/{productId}")
    @ResponseStatus(OK)
    ProductResponse getProducts(@PathVariable Integer productId) {
        return service.getProduct(productId);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    ProductResponse createProduct(@Valid @RequestBody ProductRequest request) {
        return service.createProduct(request);
    }

    @PutMapping("/{productId}")
    @ResponseStatus(OK)
    ProductResponse updateProduct(@PathVariable Integer productId, @Valid @RequestBody ProductRequest request) {
        return service.updateProduct(productId, request);
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(NO_CONTENT)
    void deleteProduct(@PathVariable Integer productId) {
        service.deleteProduct(productId);
    }
}
