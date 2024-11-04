package com.ar.mikellbobadilla.app.product;

import com.ar.mikellbobadilla.app.category.Category;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    @Id @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    @Column(length = 100, nullable = false)
    private String name;
    private String description;
    private Integer stock;
    private BigDecimal price;
    private BigDecimal cost;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
