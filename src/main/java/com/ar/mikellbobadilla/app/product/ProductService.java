package com.ar.mikellbobadilla.app.product;

import com.ar.mikellbobadilla.app.utils.PaginatedResponse;

public interface ProductService {
    PaginatedResponse<ProductResponse> getProducts(int page, int size);
    ProductResponse getProduct(Integer productId);
    ProductResponse createProduct(ProductRequest request);
    ProductResponse updateProduct(Integer productId, ProductRequest request);
    void deleteProduct(Integer productId);
}
