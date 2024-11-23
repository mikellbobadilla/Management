package com.ar.mikellbobadilla.app.product;

import com.ar.mikellbobadilla.app.category.Category;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecs {

    public static Specification<Product> hasId(String id) {
        return (root, query, builder) -> {
            if (id == null || id.isEmpty()) return null;
            try {
                Integer.parseInt(id);
            } catch (NumberFormatException ignore) {
                return null;
            }

            return builder.equal(root.get("id"), id);
        };
    }

    public static Specification<Product> hasNameLike(String productName) {
        return (root, query, builder) -> {
            if (productName == null || productName.isEmpty()) return null;

            return builder.like(builder.lower(root.get("name")), "%" + productName.toLowerCase() + "%");
        };
    }

    public static Specification<Product> hasCategoryLike(String categoryName) {
        return (root, query, builder) -> {
            if (categoryName == null || categoryName.isEmpty()) return null;

            Join<Product, Category> categoryJoin = root.join("categories", JoinType.LEFT);
            return builder.like(builder.lower(categoryJoin.get("name")), "%" + categoryName.toLowerCase() + "%");
        };
    }
}
