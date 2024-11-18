package com.ar.mikellbobadilla.app.product;

import com.ar.mikellbobadilla.app.category.Category;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Products")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @Builder
@ToString(exclude = "categories")
@EqualsAndHashCode(exclude = "categories")
public class Product {
    @Id @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    @Column(length = 100, nullable = false)
    private String name;
    private String description;
    private Integer stock;
    private BigDecimal price;
    private BigDecimal cost;
    @ManyToMany
    @JoinTable(
        name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;
}
