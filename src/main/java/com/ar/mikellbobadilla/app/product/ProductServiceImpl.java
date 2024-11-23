package com.ar.mikellbobadilla.app.product;

import com.ar.mikellbobadilla.app.category.Category;
import com.ar.mikellbobadilla.app.category.CategoryRepository;
import com.ar.mikellbobadilla.app.exceptions.ResourceNotFoundException;
import com.ar.mikellbobadilla.app.utils.PaginatedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;

    @Override
    public PaginatedResponse<ProductResponse> getAllProducts(int page, int size, String keyword) {
        Specification<Product> spec = Specification.where(null);
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());

        if (keyword != null && !keyword.isEmpty()) {
            spec = spec.or(
                    ProductSpecs.hasNameLike(keyword)
                            .or(ProductSpecs.hasCategoryLike(keyword))
                            .or(ProductSpecs.hasId(keyword))
            );
        }

        Page<Product> productPage = repository.findAll(spec, pageable);

        return new PaginatedResponse<>(
                parseListProductsToDTOList(productPage.getContent()),
                productPage
        );
    }

    @Override
    public ProductResponse getProduct(Integer productId) {
        Product product = repository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return parseToDTO(product);
    }

    @Override
    public ProductResponse createProduct(ProductRequest request) {

        List<Category> categories = categoryRepository.findAllByIdIn(request.categories());

        Product product = Product.builder()
                .name(request.name())
                .description(request.description())
                .stock(request.stock())
                .price(request.price())
                .cost(request.cost())
                .categories(categories)
                .build();
        return parseToDTO(repository.save(product));
    }

    @Override
    public ProductResponse updateProduct(Integer productId, ProductRequest request) {

        Product product = repository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        List<Category> categories = categoryRepository.findAllByIdIn(request.categories());

        product.setName(request.name());
        product.setDescription(request.description());
        product.setStock(request.stock());
        product.setPrice(request.price());
        product.setCost(request.cost());
        product.setCategories(categories);

        return parseToDTO(repository.save(product));
    }

    @Override
    public void deleteProduct(Integer productId) {
        repository.deleteById(productId);
    }

    private List<ProductResponse> parseListProductsToDTOList(List<Product> products) {
        return products.stream()
                .map(this::parseToDTO)
                .toList();
    }

    private ProductResponse parseToDTO(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getStock(),
                product.getPrice(),
                product.getCost(),
                product.getCategories()
        );
    }
}
