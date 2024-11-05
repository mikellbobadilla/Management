package com.ar.mikellbobadilla.app.product;

import com.ar.mikellbobadilla.app.category.CategoryRepository;
import com.ar.mikellbobadilla.app.utils.PaginatedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;

    @Override
    public PaginatedResponse<ProductResponse> getProducts(int page, int size) {
        return null;
    }

    @Override
    public ProductResponse getProduct(Integer productId) {
        return null;
    }

    @Override
    public ProductResponse createProduct(ProductRequest request) {
        return null;
    }

    @Override
    public ProductResponse updateProduct(Integer productId, ProductRequest request) {
        return null;
    }

    @Override
    public void deleteProduct(Integer productId) {

    }
}
